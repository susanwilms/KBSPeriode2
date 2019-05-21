/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author mbred
 */
public class Scherm extends JFrame implements ActionListener {

    private JButton webserverKnop = new JButton("Webservers");
    private JButton dbserverKnop = new JButton("Databaseserver");
    private JButton dbloadbalancerKnop = new JButton("Dbloadbalancer");
    private JButton pfsenseKnop = new JButton("Pfsense");
    private JLabel componentLabel = new JLabel("Beschikbare componenten");
    private JLabel beschikbaarheidLabel = new JLabel("Beschikbaarheid: ");
    private JLabel kostenLabel = new JLabel("Kosten: ");
    private JButton openenKnop = new JButton("Openen");
    private JButton opslaanKnop = new JButton("Opslaan");
    private JButton optimalisatieKnop = new JButton("Optimalisatie");
    private JButton monitoringKnop = new JButton("Monitoring");
    private JButton verwijderOntwerpKnop = new JButton("Verwijder Ontwerp");
    private JLabel naamLabel = new JLabel("Naam project:");
    private JTextField naamTextField = new JTextField(500);
    private JPanel panel = new JPanel(null);
    private Webserver ws1;
    private Webserver ws2;
    private Webserver ws3;
    private DatabaseServer ds1;
    private DatabaseServer ds2;
    private DatabaseServer ds3;
    private PFsense pfsense;
    private DBloadBalancer dbloadbalancer;
    private Configuratie ontwerp = new Configuratie();
    private Werkveld werkveld = new Werkveld();
    private Database connectie = new Database();
    private Oplossing oplossing;
    private ArrayList<Server> webserverArray = new ArrayList<>();
    private Configuratie optimaleOplossing;

    public Scherm(Webserver ws1, Webserver ws2, Webserver ws3, DatabaseServer ds1,
            DatabaseServer ds2, DatabaseServer ds3, PFsense PFsense,
            DBloadBalancer DBloadBalancer) {
        this.ws1 = ws1;
        this.ws2 = ws2;
        this.ws3 = ws3;
        webserverArray.add(ws1);
        webserverArray.add(ws2);
        webserverArray.add(ws3);
        this.ds1 = ds1;
        this.ds2 = ds2;
        this.ds3 = ds3;
        this.pfsense = PFsense;
        this.dbloadbalancer = DBloadBalancer;

        setTitle("Java Applicatie");
        setSize(900, 660);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);

        //Geef iedere component zijn plek waar hij moet staan
        componentLabel.setBounds(10, 10, 200, 20);
        webserverKnop.setBounds(10, 50, 200, 75);
        dbserverKnop.setBounds(10, 135, 200, 75);
        dbloadbalancerKnop.setBounds(10, 220, 200, 75);
        pfsenseKnop.setBounds(10, 305, 200, 75);
        beschikbaarheidLabel.setBounds(10, 400, 200, 15);
        kostenLabel.setBounds(10, 420, 200, 15);
        openenKnop.setBounds(10, 440, 200, 30);
        opslaanKnop.setBounds(10, 477, 200, 30);
        optimalisatieKnop.setBounds(10, 514, 200, 30);
        monitoringKnop.setBounds(10, 551, 200, 30);
        verwijderOntwerpKnop.setBounds(10, 588, 200, 30);
        naamLabel.setBounds(230, 10, 100, 20);
        naamTextField.setBounds(330, 13, 545, 20);
        panel.setBounds(0, 0, 220, 800);
        werkveld.setBounds(230, 43, 643, 560);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        //Zet de font naar onze 'main' font Helvetica Neue + Lettertype
        componentLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        beschikbaarheidLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        kostenLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        webserverKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        dbserverKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        dbloadbalancerKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        pfsenseKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        openenKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        opslaanKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        optimalisatieKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        monitoringKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        verwijderOntwerpKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        naamLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

        //Zorgt ervoor dat de inhoud van de knoppen links weergeven wordt
        webserverKnop.setHorizontalAlignment(SwingConstants.LEFT);
        dbserverKnop.setHorizontalAlignment(SwingConstants.LEFT);
        dbloadbalancerKnop.setHorizontalAlignment(SwingConstants.LEFT);
        pfsenseKnop.setHorizontalAlignment(SwingConstants.LEFT);

        //Veranderd de achtergrondkleur van componenten
        panel.setBackground(new Color(102, 255, 255));
        webserverKnop.setBackground(Color.white);
        dbserverKnop.setBackground(Color.white);
        dbloadbalancerKnop.setBackground(Color.white);
        pfsenseKnop.setBackground(Color.white);
        opslaanKnop.setBackground(new Color(204, 255, 255));
        openenKnop.setBackground(new Color(204, 255, 255));
        optimalisatieKnop.setBackground(new Color(204, 255, 255));
        monitoringKnop.setBackground(new Color(204, 255, 255));
        verwijderOntwerpKnop.setBackground(new Color(204, 255, 255));
        naamTextField.setBackground(new Color(204, 255, 255));

        //Zorgt ervoor dat de buttons geen omringende border hebben (geen zwart lijntje aan de uiteinden)
        webserverKnop.setBorder(null);
        dbserverKnop.setBorder(null);
        dbloadbalancerKnop.setBorder(null);
        pfsenseKnop.setBorder(null);
        opslaanKnop.setBorder(null);
        openenKnop.setBorder(null);
        optimalisatieKnop.setBorder(null);
        monitoringKnop.setBorder(null);
        verwijderOntwerpKnop.setBorder(null);
        naamTextField.setBorder(null);

        //Zorgt voor het plaatje bij de buttons
        webserverKnop.setIcon(new ImageIcon(this.getClass().getResource("Webserver.png")));
        dbserverKnop.setIcon(new ImageIcon(this.getClass().getResource("Databaseserver.png")));
        dbloadbalancerKnop.setIcon(new ImageIcon(this.getClass().getResource("Databasebalancing.png")));
        pfsenseKnop.setIcon(new ImageIcon(this.getClass().getResource("Firewall.png")));

        //Actionlisteners
        opslaanKnop.addActionListener(this);
        optimalisatieKnop.addActionListener(this);
        webserverKnop.addActionListener(this);
        dbserverKnop.addActionListener(this);
        dbloadbalancerKnop.addActionListener(this);
        pfsenseKnop.addActionListener(this);
        openenKnop.addActionListener(this);
        monitoringKnop.addActionListener(this);
        verwijderOntwerpKnop.addActionListener(this);

        //Voegt alle componenten toe
        add(componentLabel);
        add(webserverKnop);
        add(dbserverKnop);
        add(dbloadbalancerKnop);
        add(pfsenseKnop);

        add(beschikbaarheidLabel);
        add(kostenLabel);
        add(openenKnop);
        add(opslaanKnop);
        add(optimalisatieKnop);
        add(monitoringKnop);
        add(verwijderOntwerpKnop);
        add(naamLabel);
        add(naamTextField);

        add(werkveld);
        //Voeg panel als laatste toe anders zijn de andere componenten niet zichtbaar
        add(panel);

        // hier komen de controls
        setVisible(true); // toont het venster
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == opslaanKnop) {
            OpslaanDialoog dialoog = new OpslaanDialoog(this, ontwerp.berekenTotaalPrijs(), (ontwerp.berekenPercentage() * 100), naamTextField.getText(), ontwerp.getSamenstelling());
            dialoog.setLocationRelativeTo(null);
            dialoog.setVisible(true);
        }
        if (e.getSource() == openenKnop) {
            OpenenDialoog dialoog = new OpenenDialoog(this);
            dialoog.setLocationRelativeTo(null);
            dialoog.setVisible(true);
            if (dialoog.isBevestigd) {
                naamTextField.setText(connectie.getOntwerpNaam(dialoog.OpenenID));
                ArrayList<Server> Opslagcomponenten = ontwerp.stringToComponent(connectie.getComponenten(dialoog.OpenenID), werkveld, ws1, ws2, ws3, ds1, ds2, ds3, pfsense, dbloadbalancer);
                for (Server server : Opslagcomponenten) {
                    ontwerp.addToSamenstelling(server);
                    werkveld.addToLijst(server);
                    dialoog.setVisible(false);
                }
            }
        }

        if (e.getSource() == monitoringKnop) {
            MonitoringDialoog monitoringDialoog = new MonitoringDialoog(this);
            monitoringDialoog.setLocationRelativeTo(null);
            monitoringDialoog.setVisible(true);
            ontwerp.print();
        }

        if (e.getSource() == webserverKnop) {
            ToevoegenDialoog webserverKnop = new ToevoegenDialoog(this, "Webserver");
            webserverKnop.setLocation(900, 450);
            webserverKnop.setVisible(true);
            ontwerp.voegComponentToe(webserverKnop.welkeWebserver, werkveld, ws1, ws2, ws3);
        }

        if (e.getSource() == dbserverKnop) {
            ToevoegenDialoog DBserver = new ToevoegenDialoog(this, "DBserver");
            DBserver.setLocation(900, 450);
            DBserver.setVisible(true);
            ontwerp.voegComponentToe(DBserver.welkeDbserver, werkveld, ds1, ds2, ds3);
        }
        if (e.getSource() == dbloadbalancerKnop) {
            ToevoegenDialoog DBloadbalancer = new ToevoegenDialoog(this, "DBloadbalancer");
            DBloadbalancer.setLocation(900, 450);
            DBloadbalancer.setVisible(true);
            ontwerp.voegComponentToe(DBloadbalancer.welkeDbloadbalancer, werkveld, dbloadbalancer);
        }

        if (e.getSource() == pfsenseKnop) {
            ToevoegenDialoog pfsenseKnop = new ToevoegenDialoog(this, "pfsenseKnop");
            pfsenseKnop.setLocation(900, 450);
            pfsenseKnop.setVisible(true);
            ontwerp.voegComponentToe(pfsenseKnop.welkePfsense, werkveld, pfsense);
        }

        if (e.getSource() == optimalisatieKnop) {
            ArrayList<Server> oplossing = new ArrayList<>();
            OptimalisatieDialoog dialoog = new OptimalisatieDialoog(this, ws1, ws2, ws3, ds1, ds2, ds3, pfsense, dbloadbalancer);
            dialoog.setLocationRelativeTo(null);
            dialoog.setVisible(true);
            werkveld.clearLijst();
            oplossing = dialoog.getOptimalisatie();
            ontwerp.setSamenstelling(oplossing);
            for (Server server : oplossing) {
                werkveld.addToLijst(server);
            }
        }
        if (e.getSource() == verwijderOntwerpKnop) {
            werkveld.clearLijst();
            ontwerp.clearSamenstelling();
            naamTextField.setText("");
        }

        kostenLabel.setText("Kosten: " + ontwerp.berekenTotaalPrijs() + " euro");
        if (ontwerp.berekenPercentage() * 100 == 100) {
            beschikbaarheidLabel.setText("Beschikbaarheid: " + ontwerp.berekenPercentage() * 0 + "%");
        } else {
            beschikbaarheidLabel.setText("Beschikbaarheid: " + ontwerp.berekenPercentage() * 100 + "%");
        }
        repaint();

    }

}
