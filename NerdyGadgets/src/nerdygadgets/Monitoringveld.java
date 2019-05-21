/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mbred
 */
public class Monitoringveld extends JPanel {
    private String cpu;
    private String diskruimte;
    private String maxDiskruimte;

    public Monitoringveld(String cpu, String diskruimte, String maxDiskruimte) {
        this.setPreferredSize(new Dimension(150, 100));
        this.cpu = cpu;
        this.diskruimte = diskruimte;
        this.maxDiskruimte = maxDiskruimte;
        
    }

    public void paintComponent(Graphics g) {
        // teken de achtergrond
        super.paintComponent(g);
        
        int cpuPixels = Integer.parseInt(cpu) * 1;
        int diskruimtePixels = ((100*Integer.parseInt(diskruimte))/Integer.parseInt(maxDiskruimte));
        g.drawRect(15,0,45,99);
        g.drawRect(90, 0, 45, 99);
        
        g.setColor(Color.green);
        g.fillRect(16, 100-cpuPixels, 44, cpuPixels);
        g.fillRect(91, 100-diskruimtePixels,44, diskruimtePixels);
        //g.drawRect(0,0,20 , cpuPixels);


    }
 
}
