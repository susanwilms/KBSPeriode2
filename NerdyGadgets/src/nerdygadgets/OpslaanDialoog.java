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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mbred
 */
public class OpslaanDialoog extends JDialog implements ActionListener {
    private JLabel Naam = new JLabel("Naam project: " + "Projectnaam");
    private JLabel Beschikbaarheid = new JLabel("Beschikbaarheidspercentage: ");
    private JLabel Kosten = new JLabel("Kosten: " );
    private JLabel Resultaat = new JLabel("Resultaat");
    private JPanel Boven = new JPanel(null);
    private JButton Sluiten = new JButton("Sluiten");
    
    
    public OpslaanDialoog(JFrame frame, int prijs, double percentage, String naam) {
        super(frame, true);
        setSize(500,300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        
        Naam.setText("Naam project: " + naam);
        Kosten.setText("Kosten: " + prijs + " euro");
        Beschikbaarheid.setText("Beschikbaarheidspercentage: " + percentage + "%");
        
        Boven.setBounds(0,0, 500,28);
        Resultaat.setBounds(210,5,100,20);
        Naam.setBounds(10, 50, 500, 20);
        Beschikbaarheid.setBounds(10,85,500,20);
        Kosten.setBounds(10, 120, 500, 20);
        Sluiten.setBounds(410, 230,80,30);

        
        Resultaat.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Naam.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Beschikbaarheid.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Kosten.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

        
        Boven.setBackground(new Color(102,255,255));
        Sluiten.setBackground(new Color(204,255,255));
        
        Sluiten.setBorder(null);
        
        Sluiten.addActionListener(this);
        
        Boven.add(Resultaat);
        add(Sluiten);
        add(Resultaat);
        add(Boven);
        add(Naam);
        add(Kosten);
        add(Beschikbaarheid);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Sluiten) {
            this.setVisible(false);
        }
    }
}
