/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mbred
 */
public class Werkveld extends JPanel {
    
    public Werkveld(){
        this.setPreferredSize(new Dimension(560,607));
    }
    
    public void paintComponent(Graphics g) {

	// teken de achtergrond
	super.paintComponent(g);

	// maak de achtergrond wit
	setBackground(new Color(204,255,255));
	
	// tekenen.. 
}
}
