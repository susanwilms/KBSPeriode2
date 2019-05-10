/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author susanwilms
 */
public class MonitoringBlok {
    private JPanel Comp1 = new JPanel();            //blauwe paneel
    private JPanel StatusColor1 = new JPanel();     //Status paneel
    private JLabel beschikbaar = new JLabel("Beschikbaar:");
    private JLabel tijd = new JLabel("Tijd beschikbaar:");
    private JLabel processor = new JLabel("Processorbelasting:");
    private JLabel disk = new JLabel("Diskruimte beschikbaar:");
    
    public MonitoringBlok(int status, String beschikbaar, int processor, int disk){
        StatusColor1.setBounds (320,65,115,115);
        beschikbaar.setBounds (25,25,200,100);
        tijd.setBounds (25,55,200,100);
        processor.setBounds (25,85,200,100);
        disk.setBounds (25,115,200,100);
        disk.setBounds (25,115,200,100);
        Comp1.setBounds (20,60,420,125);
        
        beschikbaar.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        tijd.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        processor.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        disk.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        Comp1.setBackground(new Color(204,255,255));
        StatusColor1.setBackground(Color.GREEN);
        
        
        add(StatusColor1);
        add(beschikbaar);
        add(tijd);
        add(processor);
        add(disk);
        add(Comp1);
                
        
        
        
                
        
        
        
    }
    
    
    
    
}
