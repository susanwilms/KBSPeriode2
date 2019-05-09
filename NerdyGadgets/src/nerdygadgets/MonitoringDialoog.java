/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author susanwilms
 */


public class MonitoringDialoog extends JDialog implements ActionListener{
    private JLabel header = new JLabel("Monitoring");
    private JButton tab1 = new JButton("Webservers");
    private JButton tab2 = new JButton("Databaseservers");
    private JButton tab3 = new JButton("Overige");
    
    

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
