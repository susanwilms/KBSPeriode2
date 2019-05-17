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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mbred
 */
public class WebserverDialoog extends JDialog implements ActionListener{
    private JLabel Selecteren = new JLabel("Selecteren");
    private JPanel Boven = new JPanel(null);
    private JButton Sluiten = new JButton("Bevestig");
    private String[] webservers = {"HAL9001W - 80%", "HAL9002W - 90%", "HAL9003W - 95%"};
    private String[] DBServers = {"HAL9001DB - 90%", "HAL9002DB - 95%", "HAL9003DB - 98%" };
    private String[] DBloadbalancers = {"Loadbalancer - 99.999%"};
    private String[] Firewall = {"PFsense - 99.999%"};
    private JComboBox Combobox;
    public int WelkeWebserver;
    public int WelkeDBserver;
    public int WelkeDBloadbalancer;
    public int WelkeFirewall;
    private String type;
    
    
    public WebserverDialoog(JFrame frame, String type) {
        super(frame, true);
        setSize(250,150);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.type = type;
        
        if(type == "Webserver") {
            Combobox = new JComboBox(webservers);  
        } else if(type == "DBserver") {
            Combobox = new JComboBox(DBServers);    
        } else if(type == "DBloadbalancer") {
            Combobox = new JComboBox(DBloadbalancers);    
        } else if(type == "Firewall") {
            Combobox = new JComboBox(Firewall);      
        }
                
        WelkeWebserver = 0;
        WelkeDBserver = 0;
        WelkeDBloadbalancer = 0;
        WelkeFirewall = 0;
        
        Boven.setBounds(0,0, 500,28);
        Selecteren.setBounds(90,5,100,20);
        Sluiten.setBounds(90, 80,80,30);
        Combobox.setBounds(60,50,140,20);
        
        Selecteren.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Sluiten.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

        
        Boven.setBackground(new Color(102,255,255));
        Sluiten.setBackground(new Color(204,255,255)); 
        Sluiten.setBorder(null);
        
        Sluiten.addActionListener(this);
        
        Boven.add(Selecteren);
        add(Sluiten);
        add(Boven);
        add(Combobox);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Sluiten) {
            
            if(type == "Webserver") {
                if(Combobox.getSelectedItem().toString().contains("HAL9001W")) {
                    WelkeWebserver = 1;
                } else if (Combobox.getSelectedItem().toString().contains("HAL9002W")) {
                    WelkeWebserver = 2;
                } else if(Combobox.getSelectedItem().toString().contains("HAL9003W")) {
                    WelkeWebserver = 3;
                }
            } else if(type.equals("DBserver")) {
                if(Combobox.getSelectedItem() == "HAL9001DB - 90%") {
                    WelkeDBserver = 1;
                } else if (Combobox.getSelectedItem() == "HAL9002DB - 95%") {
                    WelkeDBserver = 2;
                } else if(Combobox.getSelectedItem() == "HAL9003DB - 98%") {
                    WelkeDBserver = 3;
                } 
            } else if(type == "DBloadbalancer") {
                if(Combobox.getSelectedItem() == "Loadbalancer - 99.999%") {
                    WelkeDBloadbalancer = 1;
                }
            } else if(type == "Firewall") {
                    if(Combobox.getSelectedItem() == "PFsense - 99.999%") {
                        WelkeFirewall = 1;
                }
            }
            setVisible(false);
        }
    }
}
