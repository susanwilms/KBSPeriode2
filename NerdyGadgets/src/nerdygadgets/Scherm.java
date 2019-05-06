/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JButton webserver = new JButton("Webservers");
    private JButton DBServer = new JButton("Databaseserver");
    private JButton DBBalancer = new JButton("DBBalancer");
    private JButton Firewall = new JButton("Firewall");
    private JLabel Componenten = new JLabel("Beschikbare componenten");
    private JLabel Beschikbaarheid = new JLabel("Beschikbaarheid: " + "%");
    private JLabel Kosten = new JLabel("Kosten: $");
    private JButton Openen = new JButton("Openen");
    private JButton Opslaan = new JButton("Opslaan");
    private JButton Optimalisatie = new JButton("Optimalisatie");
    private JButton Berekenen = new JButton("Kosten Berekenen");
    private JLabel Naam = new JLabel("Naam project:");
    private JTextField NaamTF = new JTextField(500);
    private JPanel p = new JPanel(null);
    
    
    
	public Scherm() {
		setTitle("Java Applicatie");
		setSize(900,660);
		setLayout(null);
                setResizable(false);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                this.getContentPane().setBackground(Color.WHITE);
                
                Werkveld werkveld = new Werkveld();
                
                
                //Geef iedere component zijn plek waar hij moet staan
                Componenten.setBounds(10, 10, 200, 20);
                webserver.setBounds(10, 50, 200, 75);
                DBServer.setBounds(10, 135, 200, 75);
                DBBalancer.setBounds(10, 220, 200, 75);
                Firewall.setBounds(10, 305, 200, 75);
                Beschikbaarheid.setBounds(10, 400, 200, 15);
                Kosten.setBounds(10,420,200,15);
                Openen.setBounds(10, 455, 200, 30);
                Opslaan.setBounds(10, 495, 200, 30);
                Optimalisatie.setBounds(10, 535, 200, 30);
                Berekenen.setBounds(10, 575, 200, 30);
                Naam.setBounds(230,10,100,20);
                NaamTF.setBounds(330,13,545,20);
                p.setBounds (0,0,220,800);
                werkveld.setBounds(230,43,643,560);
                
                //Zet de font naar onze 'main' font Helvetica Neue + Lettertype
                Componenten.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
                Beschikbaarheid.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Kosten.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                webserver.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                DBServer.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                DBBalancer.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Firewall.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Openen.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Opslaan.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Optimalisatie.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                Berekenen.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));       
                Naam.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                
                //Zorgt ervoor dat de inhoud van de knoppen links weergeven wordt
                webserver.setHorizontalAlignment(SwingConstants.LEFT);
                DBServer.setHorizontalAlignment(SwingConstants.LEFT);
                DBBalancer.setHorizontalAlignment(SwingConstants.LEFT);
                Firewall.setHorizontalAlignment(SwingConstants.LEFT);


                //Veranderd de achtergrondkleur van componenten
                p.setBackground(new Color(102,255,255));
                webserver.setBackground(Color.white);
                DBServer.setBackground(Color.white);
                DBBalancer.setBackground(Color.white);
                Firewall.setBackground(Color.white);
                Opslaan.setBackground(new Color(204,255,255));
                Openen.setBackground(new Color(204,255,255));
                Optimalisatie.setBackground(new Color(204,255,255));
                Berekenen.setBackground(new Color(204,255,255));
                NaamTF.setBackground(new Color(204,255,255));

                
                //Zorgt ervoor dat de buttons geen omringende border hebben (geen zwart lijntje aan de uiteinden)
                webserver.setBorder(null);
                DBServer.setBorder(null);
                DBBalancer.setBorder(null);
                Firewall.setBorder(null);
                Opslaan.setBorder(null);
                Openen.setBorder(null);
                Optimalisatie.setBorder(null);
                Berekenen.setBorder(null);
                NaamTF.setBorder(null);
                
                
                //Zorgt voor het plaatje bij de buttons
                webserver.setIcon(new ImageIcon(this.getClass().getResource("Webserver.png")));  
                DBServer.setIcon(new ImageIcon(this.getClass().getResource("Databaseserver.png")));  
                DBBalancer.setIcon(new ImageIcon(this.getClass().getResource("Databasebalancing.png")));  
                Firewall.setIcon(new ImageIcon(this.getClass().getResource("Firewall.png")));  
                
                //Actionlisteners
                Opslaan.addActionListener(this);
                Optimalisatie.addActionListener(this);
                
                //Voegt alle componenten toe 
                add(Componenten);
                add(webserver);
                add(DBServer);
                add(DBBalancer);
                add(Firewall);
                add(Beschikbaarheid);
                add(Kosten);
                add(Openen);
                add(Opslaan);
                add(Optimalisatie);
                add(Berekenen);
                add(Naam);
                add(NaamTF);
                add(werkveld);
                //Voeg panel als laatste toe anders zijn de andere componenten niet zichtbaar
                add(p);
                
		// hier komen de controls
		
		setVisible(true); // toont het venster
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Opslaan) {
            OpslaanDialoog dialoog = new OpslaanDialoog(this);	
            dialoog.setVisible(true);

        }
        if(e.getSource() == Optimalisatie){
            ArrayList<Server> besteOplossing = new ArrayList<>();
            
        }
    }
}


