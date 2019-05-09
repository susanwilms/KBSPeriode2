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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author susanwilms
 */


public class MonitoringDialoog extends JDialog implements ActionListener{
    private JLabel header = new JLabel("Monitoring");
    private JButton tab1 = new JButton("Webservers");
    private JButton tab2 = new JButton("Databaseservers");
    private JButton tab3 = new JButton("Overige");
    
    public MonitoringDialoog(JFrame frame) {
        super(frame, true);
        setSize(900,660);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        
        
        
        header.setBounds                        (0, 0, 900, 40);
        header.setHorizontalAlignment           (JLabel.CENTER);
        tab1.setBounds                          (0, 50, 150, 40);
        tab2.setBounds                          (150, 50, 150, 40);
        tab3.setBounds                          (300, 50, 150, 40);
        // bounds voor de blokken
        
        header.                         setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        tab1.                           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        tab2.                           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        tab3.                           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        // fonts voor de tabs
        
        header.setOpaque(true);
        header.setBackground(new Color(102,255,255));
        tab1.setOpaque(true);
        tab2.setOpaque(true);
        tab3.setOpaque(true);
        // opaque voor de bokken
        
        
        tab1.addActionListener(this);
        tab2.addActionListener(this);
        tab3.addActionListener(this);
        
        add(header);
        add(tab1);
        add(tab2);
        add(tab3);
    }
    

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tab1) {
            tab1.setBackground(new Color(204,255,255));
            tab2.setBackground(Color.WHITE);
            tab3.setBackground(Color.WHITE);
            // add blokken van servers
        }
        if(e.getSource() == tab2) {
            tab1.setBackground(Color.WHITE);
            tab2.setBackground(new Color(204,255,255));
            tab3.setBackground(Color.WHITE);
        }
        if(e.getSource() == tab3) {
            tab1.setBackground(Color.WHITE);
            tab2.setBackground(Color.WHITE);
            tab3.setBackground(new Color(204,255,255));
        }
        
    }

}
