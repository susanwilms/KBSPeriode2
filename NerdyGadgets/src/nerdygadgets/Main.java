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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FysiekComponent FysiekeWs1 = new FysiekComponent();
        FysiekComponent FysiekeWs2 = new FysiekComponent();
        FysiekComponent FysiekeDb1 = new FysiekComponent();
        FysiekComponent FysiekeDb2 = new FysiekComponent();
        FysiekComponent FysiekeDBbalancer = new FysiekComponent();
        
        ArrayList<FysiekComponent> FysiekeComponenten = new ArrayList<>(); 
        
        FysiekeComponenten.add(FysiekeWs1);
        FysiekeComponenten.add(FysiekeWs2);
        FysiekeComponenten.add(FysiekeDb1);
        FysiekeComponenten.add(FysiekeDb2);
        FysiekeComponenten.add(FysiekeDBbalancer);
        
        Webserver a = new Webserver("HAL9001W", 2200, 0.8);
        Webserver b = new Webserver("HAL9002W", 3200, 0.9);
        Webserver c = new Webserver("HAL9003W", 5100, 0.95);
        DatabaseServer d = new DatabaseServer("HAL9001DB", 5100, 0.90);
        DatabaseServer e = new DatabaseServer("HAL9002DB", 7700, 0.95);
        DatabaseServer f = new DatabaseServer("HAL9003DB", 12200, 0.98);
        


        PFsense g = new PFsense("PFsense", 2000, 0.99999);
        DBloadBalancer h = new DBloadBalancer("DB loadbalancer", 2000, 0.99999);
        
        Scherm test = new Scherm(a,b,c,d,e,f,g,h, FysiekeComponenten);
        ArrayList<Webserver> webservers = new ArrayList<>();
        ArrayList<DatabaseServer> dbServers = new ArrayList<>();
        
        webservers.add(a);
        webservers.add(b);
        webservers.add(c);
        dbServers.add(d);
        dbServers.add(e);
        dbServers.add(f);
        
        /*Draad Component1 = new Draad("Component1", FysiekeWs1,"200");
        Draad Component2 = new Draad("Component2", FysiekeWs2,"200");
        Draad Component3 = new Draad("Component3", FysiekeDb1,"200");
        Draad Component4 = new Draad("Component4", FysiekeDb2,"200");
        Draad Component5 = new Draad("Component5", FysiekeDBbalancer,"200");
        
        Component1.start();
*/
    }
}  
    
   
