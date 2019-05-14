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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author susanwilms
 */
public class OptimalisatieDialoog extends JDialog implements ActionListener{
    private JLabel      Header                          = new JLabel    ("Optimalisatie");
    private JLabel      Naam                            = new JLabel    ("Naam Project: " + "Projectnaam");
    private JLabel      GewenstePercentage              = new JLabel    ("Gewenste percentage: ");
    private JTextField  PercentageTF                    = new JTextField(500);
    private JLabel      Componenten                     = new JLabel    ("Voorgedefinieerde componenten: "); 
    private JLabel      DBbalancingServer               = new JLabel ("Databaseserver");
    private JTextField  AantalDBbalancingServers        = new JTextField(2);
    private JLabel      DBloadBalancingServer           = new JLabel ("Databaseloadbalancer");
    private JTextField  AantalDBloadBalancingServers    = new JTextField(2);
    private JLabel      PFsenseRouter                   = new JLabel ("PFsense router");
    private JTextField  AantalPFsenseRouters            = new JTextField(2);
    private JLabel      Webserver                       = new JLabel ("Webserver");
    private JTextField  AantalWebservers                = new JTextField(2);
    private JButton     Optimaliseer                    = new JButton   ("Optimaliseer");
   
    private ArrayList<Server> webservers                = new ArrayList<>();
    private ArrayList<Server> dbservers                 = new ArrayList<>();
    private PFsense pfsense;
    private DBloadBalancer dbloadbalancer;
    private Webserver ws1;
    private Webserver ws2;
    private Webserver ws3;
    private DatabaseServer ds1;
    private DatabaseServer ds2;
    private DatabaseServer ds3;
    private ArrayList<Server> besteOplossing            = new ArrayList<>();
    
    public OptimalisatieDialoog(JFrame frame, Webserver ws1, Webserver ws2, Webserver ws3, DatabaseServer ds1,
                        DatabaseServer ds2, DatabaseServer ds3, PFsense PFsense,
                        DBloadBalancer DBloadBalancer) {
        super(frame, true);
        setSize(550,300);
        setLayout(null);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        
        Header.setBounds                        (0, 0, 550, 40);
        Header.setHorizontalAlignment(JLabel.CENTER);
        Naam.setBounds                          (10, 50, 275, 20);
        GewenstePercentage.setBounds            (10, 80, 275, 20);
        PercentageTF.setBounds                  (275, 80, 265, 20);
        Componenten.setBounds                   (10, 110, 275, 20);
        DBbalancingServer.setBounds             (275, 110, 230, 20);
        AantalDBbalancingServers.setBounds      (505, 110, 35, 20);
        DBloadBalancingServer.setBounds         (275, 140, 230, 20);
        AantalDBloadBalancingServers.setBounds  (505, 140, 35, 20);
        PFsenseRouter.setBounds                 (275, 170, 230, 20);
        AantalPFsenseRouters.setBounds          (505, 170, 35, 20);
        Webserver.setBounds                     (275, 200, 230, 20);
        AantalWebservers.setBounds              (505, 200, 35, 20);
        Optimaliseer.setBounds                  (420, 230, 120, 40);
        
        
        Header.                         setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Naam.                           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        GewenstePercentage.             setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        PercentageTF.                   setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Componenten.                    setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        DBbalancingServer.              setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalDBbalancingServers.       setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        DBloadBalancingServer.          setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalDBloadBalancingServers.   setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        PFsenseRouter.                  setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalPFsenseRouters.           setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Webserver.                      setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        AantalWebservers.               setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        Optimaliseer.                   setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        
        Header.setOpaque(true);
        Header.setBackground(new Color(102,255,255));
        PercentageTF.setOpaque(true);
        PercentageTF.setBackground(new Color(204,255,255));
        AantalDBbalancingServers.setOpaque(true);
        AantalDBbalancingServers.setBackground(new Color(204,255,255));
        AantalDBloadBalancingServers.setOpaque(true);
        AantalDBloadBalancingServers.setBackground(new Color(204,255,255));
        AantalPFsenseRouters.setOpaque(true);
        AantalPFsenseRouters.setBackground(new Color(204,255,255));
        AantalWebservers.setOpaque(true);
        AantalWebservers.setBackground(new Color(204,255,255));
        Optimaliseer.setOpaque(true);
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
        add(Optimaliseer);
        
        //webservers worden toegevoegd aan Array met webservers
            this.ws1 = ws1;
            this.ws2 = ws2;
            this.ws3 = ws3;
            webservers.add(ws1);
            webservers.add(ws2);
            webservers.add(ws3);
            
            this.ds1 = ds1;
            this.ds2 = ds2;
            this.ds3 = ds3;
            dbservers.add(ds1);
            dbservers.add(ds2);
            dbservers.add(ds3); //????????
            
            pfsense = PFsense;
            dbloadbalancer = DBloadBalancer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Optimaliseer) {
            //Berekenen optimale oplossing.
            if(getPercentage() != 0 ){
                //Als het percentage niet 0 is wordt de optimale oplossing berekent en kan het scherm verdwijnen. 
                this.setVisible(false);
            Oplossing oplossing = new Oplossing(ws1, ws2, ws3, ds1, ds2, ds3, pfsense, dbloadbalancer, getPercentage());
            oplossing.berekenBesteOplossing(besteOplossing, webservers);
            besteOplossing = oplossing.getOplossing();
            for(Server server : besteOplossing){
                System.out.println(server.getNaam());
            }
            } else {
                // als het percentage wel  is moet er een foutmelding worden weergegegeven
               System.out.println("Vul een percentage in!");
            }
            
        }
    }
    
    public double getPercentage(){
        double percentage = 0;
        // Als er geen percentage is ingevoerd kan het percentage niet worden opgehaald 
        // uit de PercentageTF. Dit moet dus worden voorkomen met een if-loop. 
        if (!PercentageTF.getText().equals("")){
            percentage = Double.parseDouble(PercentageTF.getText());
            percentage = percentage / 100;
        }
        return percentage;
    }
}
