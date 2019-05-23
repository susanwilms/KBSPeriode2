/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import com.jcraft.jsch.JSchException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
public class MonitoringDialoog extends JDialog{

    private JPanel boven = new JPanel(null);
    private JLabel resultaat = new JLabel("");
    private JPanel totaal = new JPanel(null);
    private FysiekComponent server;

    public MonitoringDialoog(JFrame frame, ArrayList<FysiekComponent> FysiekeComponenten) throws JSchException, IOException  {
        super(frame, true);
        this.server = server;
        this.setSize(1000, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        totaal.setBounds(0, 0, 1000, 600);

        boven.setBounds(0, 0, 1000, 28);
        resultaat.setBounds(210, 5, 100, 20);

        resultaat.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

        boven.setBackground(new Color(102, 255, 255));
        totaal.setBackground(Color.WHITE);

        int i = 1;
        int x = 50;
        for(FysiekComponent server: FysiekeComponenten) {
            MonitoringBlok blok = new MonitoringBlok();
            JPanel jpanel = blok.maakBlok();
            Draad2 invullen = new Draad2("Ophalen", server, blok);
            invullen.start();

            if (i % 2 == 1) {
                totaal.add(jpanel);
                jpanel.setBounds(50, x, 400, 150);
            } else {
                totaal.add(jpanel);
                jpanel.setBounds(550, x, 400, 150);
                x += 175;
            }
            i++;

        }

        boven.add(resultaat);
        add(resultaat);
        add(boven);
        add(totaal);
        
        
        

    }
}
