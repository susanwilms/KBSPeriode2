/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author susanwilms
 */
public class OptimalisatieDialoog extends JDialog implements ActionListener {

    private JLabel headerLabel = new JLabel("Optimalisatie");
    private JLabel naamLabel = new JLabel();
    private JLabel percentageLabel = new JLabel("Gewenste percentage: ");
    private JTextField percentageTextField = new JTextField(500);
    private JLabel procentTekenLabel = new JLabel("%");
    private JLabel foutmeldingLabel = new JLabel("");
    private JButton optimaliseerKnop = new JButton("Optimaliseer");
    private ArrayList<Server> webserverArray = new ArrayList<>();
    private PFsense pfsense;
    private DBloadBalancer dbloadbalancer;
    private Webserver ws1;
    private Webserver ws2;
    private Webserver ws3;
    private DatabaseServer ds1;
    private DatabaseServer ds2;
    private DatabaseServer ds3;
    private ArrayList<Server> besteOplossing = new ArrayList<>();
    private double percentage;

    public OptimalisatieDialoog(JFrame frame, Webserver ws1, Webserver ws2, Webserver ws3, DatabaseServer ds1,
            DatabaseServer ds2, DatabaseServer ds3, PFsense PFsense,
            DBloadBalancer DBloadBalancer) {
        super(frame, true);
        setSize(550, 200);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        //De labels, knoppen en tekstvelden worden op de juiste positie geplaatst
        headerLabel.setBounds(0, 0, 550, 40);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        naamLabel.setBounds(10, 50, 275, 20);
        percentageLabel.setBounds(10, 80, 275, 20);
        percentageTextField.setBounds(275, 80, 235, 20);
        procentTekenLabel.setBounds(520, 80, 20, 20);
        optimaliseerKnop.setBounds(420, 125, 110, 40);
        foutmeldingLabel.setBounds(200, 110, 275, 20);

        //Het lettertype wordt veranderd
        headerLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        naamLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        percentageLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        percentageTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        optimaliseerKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        foutmeldingLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        procentTekenLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        foutmeldingLabel.setForeground(new Color(0, 128, 255));

        //met setOpaque(true) wordt er voor gezorgt dat alle pixels van het object kunnen worden ingekleurd. (zie https://stackoverflow.com/questions/2451990/setopaquetrue-false-java)
        //de onderstaande Swing atributen worden ingekleurd
        headerLabel.setOpaque(true);
        headerLabel.setBackground(new Color(102, 255, 255));
        percentageTextField.setOpaque(true);
        percentageTextField.setBackground(new Color(204, 255, 255));

        optimaliseerKnop.setOpaque(true);
        optimaliseerKnop.setBackground(new Color(204, 255, 255));
        optimaliseerKnop.setBorder(null);
        optimaliseerKnop.addActionListener(this);

        add(headerLabel);
        add(naamLabel);
        add(percentageLabel);
        add(percentageTextField);
        add(optimaliseerKnop);
        add(foutmeldingLabel);
        add(procentTekenLabel);

        //webservers worden toegevoegd aan Array met webservers
        this.ws1 = ws1;
        this.ws2 = ws2;
        this.ws3 = ws3;
        webserverArray.add(ws1);
        webserverArray.add(ws2);
        webserverArray.add(ws3);

        this.ds1 = ds1;
        this.ds2 = ds2;
        this.ds3 = ds3;

        pfsense = PFsense;
        dbloadbalancer = DBloadBalancer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optimaliseerKnop) {
            //Berekenen optimale oplossing.
            percentage = getPercentage();
            if (percentage > 0) {
                if (percentage == 0.99998) {
                    System.out.println(percentage);
                    foutmeldingLabel.setText("Geen oplossing gevonden");
                } else {
                    System.out.println(getPercentage());
                    //Als het percentage niet 0 is wordt de optimale oplossing berekent en kan het scherm verdwijnen.
                    Oplossing oplossing = new Oplossing(ws1, ws2, ws3, ds1, ds2, ds3, pfsense, dbloadbalancer);
                    try {
                        besteOplossing = oplossing.berekenBesteOplossing(percentage);
                        this.setVisible(false);
                    } catch (java.lang.StackOverflowError error) {
                        foutmeldingLabel.setText("Geen oplossing gevonden!");
                    }
                }
            } else if (getPercentage() == 0) {
                // als het percentage wel  is moet er een foutmelding worden weergegegeven
                foutmeldingLabel.setText("Vul een percentage in!");
            } else {
                foutmeldingLabel.setText("Vul een positief getal in!");
            }

        }
    }

    private double getPercentage() {
        double percentage1 = 0.0;
        // Als er geen percentage is ingevoerd kan het percentage niet worden opgehaald
        // uit de PercentageTF. Dit moet dus worden voorkomen met een if-loop.

        if (!percentageTextField.getText().equals("")) {
            try {
                percentage1 = Double.parseDouble(percentageTextField.getText());
            } catch (java.lang.NumberFormatException error) {

            }
            percentage1 = percentage1 / 100.0;
        }
        //De onderstaande code zorgt er voor dat het opgehaald getal niet wordt afgerond
        // voorbeeld zonder onderstaande code: percentage1 = 0.999980...01
        DecimalFormat formaat = new DecimalFormat("0.00000");
        String percentageString = formaat.format(percentage1);
        // DecimalFormat returned een waarde met een komma om het decimale af te scheiden.
        // Hiermee kan niet worden gerekend en moet dus worden vervangen door een punt.
        String juistPercentageString = percentageString.substring(0, 1) + "." + percentageString.substring(2);
        percentage1 = Double.parseDouble(juistPercentageString);
        return percentage1;
    }

    public ArrayList<Server> getOptimalisatie() {
        return besteOplossing;
    }
}
