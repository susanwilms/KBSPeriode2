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
    private JPanel kleurPanel;
    


    public JPanel maakBlok(){
            JLabel Type = new JLabel("Type: ");
            JLabel tijd = new JLabel("Uptime: 5 days, 20 hours");
            JLabel processor = new JLabel("Processorbelasting:");
            JLabel disk = new JLabel("Diskruimte:");
            JLabel labelCpuPercentage = new JLabel("Cpu");
            JLabel labelMemoryPercentage = new JLabel("Disk");
        
        
        Type.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        tijd.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        processor.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        disk.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        labelCpuPercentage.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        labelMemoryPercentage.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        
        kleurPanel = new Monitoringveld("66","200","400");
        kleurPanel.setBackground(Color.white);
        JPanel Blok = new JPanel(null);
        Blok.setSize(400, 150);
        Blok.setBackground(new Color(204,255,255));
        Blok.add(labelCpuPercentage);
        labelCpuPercentage.setBounds(250,120,50,30);
        Blok.add(labelMemoryPercentage);
        labelMemoryPercentage.setBounds(325,120,50,30);
        Blok.add(Type);
        Type.setBounds(5,25,200,20);
        Blok.add(tijd);
        tijd.setBounds(5,50,300,20);
        Blok.add(processor);
        processor.setBounds(5,75,200,20);
        Blok.add(disk);
        disk.setBounds(5,100,200,20);
        Blok.add(kleurPanel);
        kleurPanel.setBounds(225, 25, 150, 100);
            
        
        return Blok;
    }
 
}

