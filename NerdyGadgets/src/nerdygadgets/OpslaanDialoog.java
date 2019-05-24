/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mbred
 */
public class OpslaanDialoog extends JDialog implements ActionListener {

    private JLabel naamLabel = new JLabel("Naam project: " + "Projectnaam");
    private JLabel beschikbaarheidLabel = new JLabel("Beschikbaarheidspercentage: ");
    private JLabel kostenLabel = new JLabel("Kosten: ");
    private JLabel opslaanLabel = new JLabel("Opslaan");
    private JPanel bovenPanel = new JPanel(null);
    private JButton bevestigKnop = new JButton("Bevestig");
    private String naamOntwerp;
    private int prijsOntwerp;
    private double beschikbaarheidOntwerp;
    private Database connectie = new Database();
    private ArrayList<Server> samenstelling;
    private Configuratie ontwerp;

    public OpslaanDialoog(JFrame frame, int prijs, double percentage, String naam, ArrayList<Server> samenstelling, Configuratie ontwerp) {
        super(frame, true);
        setSize(500, 300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        bovenPanel.setBounds(0, 0, 500, 40);

        this.ontwerp = ontwerp;
        this.samenstelling = samenstelling;
        this.naamOntwerp = naam;
        this.prijsOntwerp = prijs;
        this.beschikbaarheidOntwerp = (percentage / 100);
        naamLabel.setText("Naam project: " + naam);
        kostenLabel.setText("Kosten: " + prijs + " euro");
        
        if(percentage == 100.00) {
            percentage = 0.00;
        }
        
        DecimalFormat formaat = new DecimalFormat("0.00000");
        
        beschikbaarheidLabel.setText("Beschikbaarheidspercentage: " + formaat.format(percentage) + "%");
        

        bovenPanel.setBounds(0, 0, 500, 28);
        opslaanLabel.setBounds(210, 5, 100, 20);
        naamLabel.setBounds(10, 50, 500, 20);
        beschikbaarheidLabel.setBounds(10, 85, 500, 20);
        kostenLabel.setBounds(10, 120, 500, 20);
        bevestigKnop.setBounds(410, 230, 80, 30);

        opslaanLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        naamLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        beschikbaarheidLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        kostenLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

        bovenPanel.setBackground(new Color(102, 255, 255));
        bevestigKnop.setBackground(new Color(204, 255, 255));

        bevestigKnop.setBorder(null);

        bevestigKnop.addActionListener(this);

        bovenPanel.add(opslaanLabel);
        add(bevestigKnop);
        add(opslaanLabel);
        add(bovenPanel);
        add(naamLabel);
        add(kostenLabel);
        add(beschikbaarheidLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bevestigKnop) {
            if ((connectie.checkNaam(naamOntwerp)) || (naamOntwerp == "") || (naamOntwerp.contains(" "))) {
                JOptionPane.showMessageDialog(this, "Niet opgeslagen, er is een fout met de naam van het project.");
            } else if(!ontwerp.checkComponenten(ontwerp)) {
                JOptionPane.showMessageDialog(this, "Er zijn te weinig verplichte componenten aanwezig");
            } else {
                connectie.insertinto(beschikbaarheidOntwerp, prijsOntwerp, naamOntwerp, samenstelling); 
                System.out.println("test");
            }
            setVisible(false);

        }
    }
}
