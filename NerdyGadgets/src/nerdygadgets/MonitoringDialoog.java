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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mbred
 */
public class MonitoringDialoog extends JDialog implements ActionListener {
    private JLabel Naam = new JLabel("");
    private JLabel Resultaat = new JLabel("");
    private JPanel Boven = new JPanel(null);
    private String opslaannaam;
    private int opslaanprijs;
    private double opslaanpercentage;
    private Database connectie = new Database();
    private ArrayList<Server> samenstelling;
    
    
    public MonitoringDialoog(JFrame frame) {
        super(frame, true);
        this.setSize(1000,600);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        Boven.setBounds(0, 0, 500, 40);
        
        
        Boven.setBounds(0,0, 1000,28);
        Resultaat.setBounds(210,5,100,20);
        Naam.setBounds(10, 50, 500, 20);


        
        Resultaat.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Naam.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));


        
        Boven.setBackground(new Color(102,255,255));
        
        
        
        int i = 1;
        int x = 50;
        while(i<=3) {
            
            MonitoringBlok blok = new MonitoringBlok();
            JPanel jpanel = blok.maakBlok();
            
            if(i%2 == 1) {
                jpanel.setBounds(50,x, 400,150);
                add(jpanel);
            } else {
                jpanel.setBounds(550, x, 400, 150);
                add(jpanel);
                x += 175;
            }
            i++;
            
        }
        
            
        Boven.add(Resultaat);
        add(Resultaat);
        add(Boven);
        add(Naam);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

