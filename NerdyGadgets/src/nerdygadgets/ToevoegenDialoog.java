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
public class ToevoegenDialoog extends JDialog implements ActionListener {
    private JLabel Selecteren = new JLabel("Selecteren");
    private JPanel Boven = new JPanel(null);
    private JButton Sluiten = new JButton("Bevestig");
    private JComboBox Selectie;
    
    
    public ToevoegenDialoog(JFrame frame, String type) {
        super(frame, true);
        setSize(500,300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);

        Boven.setBounds(0,0, 500,28);
        Selecteren.setBounds(210,5,100,20);

        Sluiten.setBounds(210, 200,80,30);
        
        Selecteren.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        
        Boven.setBackground(new Color(102,255,255));
        Sluiten.setBackground(new Color(204,255,255));
        
        Sluiten.setBorder(null);
        
        
        Boven.add(Selecteren);
        add(Sluiten);
        add(Boven);

   
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
