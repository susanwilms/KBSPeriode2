/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        Webserver a = new Webserver("HAL9001W", 2200, 0.8);
        Webserver b = new Webserver("HAL9002W", 3200, 0.9);
        Webserver c = new Webserver("HAL9003W", 5100, 0.95);
        DatabaseServer d = new DatabaseServer("HAL9001DB", 5100, 0.90);
        DatabaseServer e = new DatabaseServer("HAL9002DB", 7700, 0.95);
        DatabaseServer f = new DatabaseServer("HAL9003DB", 12200, 0.98);
        


        PFsense g = new PFsense("PFsense", 2000, 0.99999);
        DBloadBalancer h = new DBloadBalancer("DB loadbalancer", 2000, 0.99999);
        Oplossing oplossing = new Oplossing(a,b,c,d,e,f,g,h, 0.9999);
        
        Scherm test = new Scherm(a,b,c,d,e,f,g,h, oplossing);
        ArrayList<Webserver> webservers = new ArrayList<>();
        ArrayList<DatabaseServer> dbServers = new ArrayList<>();
        
        webservers.add(a);
        webservers.add(b);
        webservers.add(c);
        dbServers.add(d);
        dbServers.add(e);
        dbServers.add(f);
        
//        try{
//            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
//            Statement myStmt = myConn.createStatement();
//            ResultSet myRs = myStmt.executeQuery("select * from infrastructuurcomponent");
//            while(myRs.next()) {
//                System.out.println(myRs.getString("naam"));
//            }
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
 
    }
}  
    
   
