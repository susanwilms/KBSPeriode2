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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author mbred
 */
public class OpenenDialoog extends JDialog implements ActionListener {  

    private JLabel Resultaat = new JLabel("Openen");
    private JPanel Boven = new JPanel(null);
    private JButton Bevestig = new JButton("Bevestig");
    private Database connectie = new Database();
    private JList ontwerpen ;
    private ArrayList<String> ontwerpnaam = new ArrayList<>();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    public int OpenenID;
    public boolean isBevestigd;

    
    
    public OpenenDialoog(JFrame frame) {
        super(frame, true);
        setSize(500,300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        
        for(String ontwerpnaam: connectie.ontwerpenOphalen()) {
            listModel.addElement(ontwerpnaam);
        }

        ontwerpen = new JList<>(listModel);        
        JScrollPane test = new JScrollPane(ontwerpen);
        
        
        Boven.setBounds(0, 0, 500, 40);
        test.setBounds(50,50, 400,150);     
        Boven.setBounds(0,0, 500,28);
        Resultaat.setBounds(210,5,100,20);
        Bevestig.setBounds(410, 230,80,30);        
        Resultaat.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));        
        Boven.setBackground(new Color(102,255,255));
        Bevestig.setBackground(new Color(204,255,255));        
        Bevestig.setBorder(null);
        
        Bevestig.addActionListener(this);
        
        
        
        Boven.add(Resultaat);
        add((test));
        add(Bevestig);
        add(Resultaat);
        add(Boven);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Bevestig) {
            OpenenID = connectie.naamToId(ontwerpen.getSelectedValue().toString());
            isBevestigd = true;
            this.setVisible(false);
        }
    }
}

