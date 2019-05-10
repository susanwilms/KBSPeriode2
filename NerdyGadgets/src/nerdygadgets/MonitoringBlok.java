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
    private JLabel componentStatus = new JLabel();
    private JLabel componentBeschikbaar = new JLabel();
    private JLabel componentProcessor = new JLabel();
    private JLabel componentDisk = new JLabel();
    


    public void maakBlok(){
        JPanel Blok = new JPanel(null);
        Blok.setSize(200,100);
        Blok.setBackground(new Color(204,255,255));

       
    }
    
    
}
