/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MonitoringBlok {
    private JPanel Comp1 = new JPanel();            //blauwe paneel
    private JPanel StatusColor1 = new JPanel();     //Status paneel
    private JLabel Type = new JLabel("Type: ");
    private JLabel beschikbaar = new JLabel("Beschikbaar:");
    private JLabel tijd = new JLabel("Tijd beschikbaar:");
    private JLabel processor = new JLabel("Processorbelasting:");
    private JLabel disk = new JLabel("Diskruimte beschikbaar:");
    private JLabel componentStatus = new JLabel();
    private JLabel componentBeschikbaar = new JLabel();
    private JLabel componentProcessor = new JLabel();
    private JLabel componentDisk = new JLabel();
    private JPanel kleurPanel;
    


    public JPanel maakBlok(){
        beschikbaar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        tijd.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        processor.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        disk.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        
        kleurPanel = new JPanel();
        kleurPanel.setBackground(Color.red);
        JPanel Blok = new JPanel(null);
        Blok.setSize(400, 150);
        Blok.setBackground(new Color(204,255,255));
        Blok.add(beschikbaar);
        beschikbaar.setBounds(5,25,200,20);
        Blok.add(tijd);
        tijd.setBounds(5,50,200,20);
        Blok.add(processor);
        processor.setBounds(5,75,200,20);
        Blok.add(disk);
        disk.setBounds(5,100,200,20);
        Blok.add(kleurPanel);
        kleurPanel.setBounds(275, 25, 100, 100);
            
        
        return Blok;
    }
 
}

