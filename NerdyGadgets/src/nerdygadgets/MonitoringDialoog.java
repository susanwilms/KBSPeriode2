

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
import javax.swing.JScrollPane;

/**
 *
 * @author mbred
 */

public class MonitoringDialoog extends JDialog implements ActionListener {
    private JPanel Boven = new JPanel(null);
    private JLabel Resultaat = new JLabel(""); 
    private JPanel totaal = new JPanel(null);
    
    public MonitoringDialoog(JFrame frame) {
        super(frame, true);
        this.setSize(1000,600);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        

        totaal.setBounds(0,0,1000,600);
        
        Boven.setBounds(0,0, 1000,28);
        Resultaat.setBounds(210,5,100,20);
        

        
        Resultaat.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));



        
        Boven.setBackground(new Color(102,255,255));
        totaal.setBackground(Color.WHITE);
        
        int i = 1;
        int x = 50;
        while(i<=3) {
            
            MonitoringBlok blok = new MonitoringBlok();
            JPanel jpanel = blok.maakBlok();
            
            if(i%2 == 1) {
                totaal.add(jpanel);
                jpanel.setBounds(50,x, 400,150);
            } else {
                totaal.add(jpanel);
                jpanel.setBounds(550, x, 400, 150);
                x += 175;
            }
            i++;
            
        }
        
            
        Boven.add(Resultaat);
        add(Resultaat);
        add(Boven);
        add(totaal);

        
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

