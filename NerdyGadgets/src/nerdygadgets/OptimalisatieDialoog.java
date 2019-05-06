/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;


import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author susanwilms
 */
public class OptimalisatieDialoog extends JDialog implements ActionListener{
    private JLabel Header = new JLabel ("Optimalisatie");
    private JLabel Naam = new JLabel ("Naam Project: " + "Projectnaam");
    private JLabel GewenstePercentage = new JLabel ("Gewenste percentage: ");
    private JTextField PercentageTF = new JTextField(500);
    private JLabel Componenten = new JLabel ("Voorgedefinieerde componenten: "); 
    private JCheckBox DBbalancingServer = new JCheckBox("Database balancing server");
    private JTextField AantalDBbalancingServers = new JTextField(2);
    private JCheckBox DBloadBalancingServer = new JCheckBox("Database loadbalancing server");
    private JTextField AantalDBloadBalancingServers = new JTextField(2);
    private JCheckBox PFsenseRouter = new JCheckBox("PFsense router");
    private JTextField AantalPFsenseRouters = new JTextField(2);
    private JCheckBox Webserver = new JCheckBox("Webserver");
    private JTextField AantalWebservers = new JTextField(2);
    private JPanel Boven = new JPanel(null);
    private JButton Optimaliseer = new JButton("Optimaliseer");
    
    public OptimalisatieDialoog(JFrame frame) {
        super(frame, true);
        setSize(500,300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        
        add()
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
