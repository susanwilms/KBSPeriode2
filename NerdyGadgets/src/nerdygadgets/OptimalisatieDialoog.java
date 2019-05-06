/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;


import java.awt.Color;
import java.awt.Font;
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
        
        Header.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Naam.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        GewenstePercentage.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        PercentageTF.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Componenten.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        DBbalancingServer.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalDBbalancingServers.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        DBloadBalancingServer.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalDBloadBalancingServers.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        PFsenseRouter.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalPFsenseRouters.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Webserver.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalWebservers.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Boven.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Optimaliseer.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        
        Optimaliseer.setBackground(new Color(204,255,255));
        
        Optimaliseer.setBorder(null);
        
        Optimaliseer.addActionListener(this);
        
        add(Header);
        add(Naam);
        add(GewenstePercentage);
        add(PercentageTF);
        add(Componenten);
        add(DBbalancingServer);
        add(AantalDBbalancingServers);
        add(DBloadBalancingServer);
        add(AantalDBloadBalancingServers);
        add(PFsenseRouter);
        add(AantalPFsenseRouters);
        add(Webserver);
        add(AantalWebservers);
        add(Boven);
        add(Optimaliseer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Optimaliseer) {
            this.setVisible(false);
        }
    }
}
