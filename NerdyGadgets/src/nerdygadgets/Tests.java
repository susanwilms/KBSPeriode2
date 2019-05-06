/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.util.ArrayList;

/**
 *
 * @author mbred
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scherm test = new Scherm();
        Webserver a = new Webserver("HAL9001W", 2200, 0.8);
        Webserver b = new Webserver("HAL9002W", 3200, 0.9);
        Webserver c = new Webserver("HAL9003W", 5100, 0.95);
        DatabaseServer d = new DatabaseServer("", 5100, 0.9);
        DatabaseServer e = new DatabaseServer("", 7700, 0.95);
        DatabaseServer f = new DatabaseServer("", 12200, 0.98);
        Firewall g = new Firewall("", 2000, 0.9999);
        DBloadbalancer h = new DBloadbalancer("", 2000, 0.9999);
        
        ArrayList<Webserver> webservers = new ArrayList<>();
        ArrayList<Databaseserver> dbServers = new ArrayList<>();
        
        webservers.add(a);
        webservers.add(b);
        webservers.add(c);
        dbServers.add(d);
        dbServers.add(e);
        dbServers.add(f);
    }
    
}
