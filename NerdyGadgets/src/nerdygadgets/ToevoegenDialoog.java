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


    private JLabel selecteerLabel = new JLabel("Selecteren");
    private JPanel bovenPanel = new JPanel(null);
    private JButton sluitKnop = new JButton("Bevestig");
    private String[] webserverArray = {"HAL9001W - 80%", "HAL9002W - 90%", "HAL9003W - 95%"};
    private String[] dbserverArray = {"HAL9001DB - 90%", "HAL9002DB - 95%", "HAL9003DB - 98%"};
    private String[] dbloadbalancerArray = {"Loadbalancer - 99.999%"};
    private String[] pfsenseArray = {"PFsense - 99.999%"};
    private JComboBox Combobox;
    public int welkeWebserver;
    public int welkeDbserver;
    public int welkeDbloadbalancer;
    public int welkePfsense;
    private String type;

    public ToevoegenDialoog(JFrame frame, String type) {
        super(frame, true);
        setSize(250, 150);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.type = type;

        if (type == "Webserver") {
            Combobox = new JComboBox(webserverArray);
        } else if (type == "DBserver") {
            Combobox = new JComboBox(dbserverArray);
        } else if (type == "DBloadbalancer") {
            Combobox = new JComboBox(dbloadbalancerArray);
        } else if (type == "pfsense") {
            Combobox = new JComboBox(pfsenseArray);
        }

        welkeWebserver = 0;
        welkeDbserver = 0;
        welkeDbloadbalancer = 0;
        welkePfsense = 0;

        bovenPanel.setBounds(0, 0, 500, 28);
        selecteerLabel.setBounds(90, 5, 100, 20);
        sluitKnop.setBounds(90, 80, 80, 30);
        Combobox.setBounds(60, 50, 140, 20);

        selecteerLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        sluitKnop.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));

        bovenPanel.setBackground(new Color(102, 255, 255));
        sluitKnop.setBackground(new Color(204, 255, 255));
        sluitKnop.setBorder(null);

        sluitKnop.addActionListener(this);

        bovenPanel.add(selecteerLabel);
        add(sluitKnop);
        add(bovenPanel);
        add(Combobox);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sluitKnop) {

            if (type.equals("Webserver")) {
                if (Combobox.getSelectedItem().toString().contains("HAL9001W")) {
                    welkeWebserver = 1;
                } else if (Combobox.getSelectedItem().toString().contains("HAL9002W")) {
                    welkeWebserver = 2;
                } else if (Combobox.getSelectedItem().toString().contains("HAL9003W")) {
                    welkeWebserver = 3;
                }
            } else if (type.equals("DBserver")) {
                if (Combobox.getSelectedItem() == "HAL9001DB - 90%") {
                    welkeDbserver = 1;
                } else if (Combobox.getSelectedItem() == "HAL9002DB - 95%") {
                    welkeDbserver = 2;
                } else if (Combobox.getSelectedItem() == "HAL9003DB - 98%") {
                    welkeDbserver = 3;
                }
            } else if (type.equals("DBloadbalancer")) {
                if (Combobox.getSelectedItem() == "Loadbalancer - 99.999%") {
                    welkeDbloadbalancer = 1;
                }
            } else if (type.equals("pfsense")) {
                if (Combobox.getSelectedItem() == "PFsense - 99.999%") {
                    welkePfsense = 1;
                }
            }
            setVisible(false);
        }
    }
}
