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
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private JLabel componentenLabel = new JLabel("Voorgedefinieerde componenten: ");
    private JLabel databaseserverLabel = new JLabel("Databaseserver");
    private JLabel foutmeldingLabel = new JLabel("");
    private JTextField aantalDbserversTextField = new JTextField(2);
    //private JLabel      DBloadbalancer                   = new JLabel ("Databaseloadbalancer");
    //private JTextField  AantalDBloadBalancingServers    = new JTextField(2);
    // private JLabel      PFsenseRouter                   = new JLabel ("PFsense router");
    //private JTextField  AantalPFsenseRouters            = new JTextField(2);
    private JLabel webserverLabel = new JLabel("Webserver");
    private JTextField aantalWebserversTextfield = new JTextField(2);
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
        setSize(550, 300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        headerLabel.setBounds(0, 0, 550, 40);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        naamLabel.setBounds(10, 50, 275, 20);
        percentageLabel.setBounds(10, 80, 275, 20);
        percentageTextField.setBounds(275, 80, 265, 20);
        componentenLabel.setBounds(10, 155, 275, 20);
        databaseserverLabel.setBounds(275, 140, 230, 20);
        aantalDbserversTextField.setBounds(505, 140, 35, 20);
        //DBloadBalancingServer.setBounds         (275, 140, 230, 20);
        //AantalDBloadBalancingServers.setBounds  (505, 140, 35, 20);
        //PFsenseRouter.setBounds                 (275, 170, 230, 20);
        //AantalPFsenseRouters.setBounds          (505, 170, 35, 20);
        webserverLabel.setBounds(275, 170, 230, 20);
        aantalWebserversTextfield.setBounds(505, 170, 35, 20);
        optimaliseerKnop.setBounds(420, 230, 120, 40);
        foutmeldingLabel.setBounds(200, 110, 275, 20);

        headerLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        naamLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        percentageLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        percentageTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        componentenLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        databaseserverLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        aantalDbserversTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        //DBloadBalancingServer.          setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        //AantalDBloadBalancingServers.   setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        //PFsenseRouter.                  setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        //AantalPFsenseRouters.           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        webserverLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        aantalWebserversTextfield.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        optimaliseerKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        foutmeldingLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        foutmeldingLabel.setForeground(new Color(0, 128, 255));

        headerLabel.setOpaque(true);
        headerLabel.setBackground(new Color(102, 255, 255));
        percentageTextField.setOpaque(true);
        percentageTextField.setBackground(new Color(204, 255, 255));
        aantalDbserversTextField.setOpaque(true);
        aantalDbserversTextField.setBackground(new Color(204, 255, 255));
        //AantalDBloadBalancingServers.setOpaque(true);
        //AantalDBloadBalancingServers.setBackground(new Color(204,255,255));
        //AantalPFsenseRouters.setOpaque(true);
        //AantalPFsenseRouters.setBackground(new Color(204,255,255));
        aantalWebserversTextfield.setOpaque(true);
        aantalWebserversTextfield.setBackground(new Color(204, 255, 255));
        optimaliseerKnop.setOpaque(true);
        optimaliseerKnop.setBackground(new Color(204, 255, 255));

        optimaliseerKnop.setBorder(null);

        optimaliseerKnop.addActionListener(this);

        add(headerLabel);
        add(naamLabel);
        add(percentageLabel);
        add(percentageTextField);
        add(componentenLabel);
        add(databaseserverLabel);
        add(aantalDbserversTextField);
        //add(DBloadBalancingServer);
        //add(AantalDBloadBalancingServers);
        //add(PFsenseRouter);
        //add(AantalPFsenseRouters);
        add(webserverLabel);
        add(aantalWebserversTextfield);
        add(optimaliseerKnop);
        add(foutmeldingLabel);

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
                        besteOplossing = oplossing.berekenBesteOplossing(percentage, getAantalWebservers(), getAantalDatabaseservers());
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
        return percentage1;
    }

    private int getAantalWebservers() {
        int aantalWebservers = 0;
        if (!aantalWebserversTextfield.getText().equals("")) {
            aantalWebservers = Integer.parseInt(aantalWebserversTextfield.getText());
        }
        return aantalWebservers;
    }

    private int getAantalDatabaseservers() {
        int aantalDatabaseservers = 0;
        if (!aantalDbserversTextField.getText().equals("")) {
            aantalDatabaseservers = Integer.parseInt(aantalDbserversTextField.getText());
        }
        return aantalDatabaseservers;
    }

    public ArrayList<Server> getOptimalisatie() {
        return besteOplossing;
    }
}
