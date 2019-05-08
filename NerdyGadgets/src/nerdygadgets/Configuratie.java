/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.util.ArrayList;

/**
 *
 * @author susanwilms
 */
public class Configuratie {
    // variabelen voor configuratie
    private ArrayList<Server> samenstelling = new ArrayList<Server>();
    private double percentageDoei;
    
    // constructor die componenten zelf uitzoekt en optimaliseerd
    public Configuratie(double percentageDoei){
        this.percentageDoei = percentageDoei;
    }
    
    public Configuratie(ArrayList<Server> samenstelling) {
        this.samenstelling = samenstelling;
    }

    public ArrayList<Server> getSamenstelling() {
        return samenstelling;
    }

    public double getPercentageDoei() {
        return percentageDoei;
    }
    
    
    // constructor die gebruikt wordt bij het maken van een nieuw ontwerp
    public Configuratie() {
        
    }
    
    public void print() {
        for(Server test: samenstelling) {
            System.out.println(test.toString());
        }
    }
    
    // functie berekening
    public int Berekening(){
        // pseudocode
        return 2;
    }
    
    // fucntie voor berekenen voor totaalprijs
    public int BerekenTotaalPrijs(){
        int prijs = 0;
        for(Server component: samenstelling ) {
            prijs += component.getPrijs();
        }
        return prijs;
    }
    
    public double BerekenPercentage(){
        ArrayList<Double> percentage = new ArrayList<>();
        ArrayList<Double> webserverlijst = new ArrayList<>();
        ArrayList<Double> databaseserverlijst = new ArrayList<>();
        double firewall = 1;
        double DBLoader = 1;
        double totaal = 1;
        int aantal = 0;
        
        for(Server component: samenstelling) {
            if(component instanceof Webserver) {
                webserverlijst.add(component.getBeschikbaarheid());
                
            } else if (component instanceof DatabaseServer) {
                databaseserverlijst.add(component.getBeschikbaarheid());
            } else if (component instanceof PFsense) {
                firewall = component.getBeschikbaarheid();
            } else {
                DBLoader = component.getBeschikbaarheid();
            }
            aantal += 1;      
        }
        if(aantal <= 1) {
            for(Server component: samenstelling) {
                totaal -= 1;
                totaal += component.getBeschikbaarheid();
            }
        } else {
            if(webserverlijst.size() <= 1 && databaseserverlijst.size() <= 1) {
                for(Server component: samenstelling) {                   
                totaal *= component.getBeschikbaarheid();
                }
            } else {
                double webserverpercentage = 1;
                double databaseserverpercentage = 1;
                for(double webserver: webserverlijst) {                   
                    webserverpercentage *= (1-webserver);
                }
                for(double databaseserver: databaseserverlijst) {
                    databaseserverpercentage *= (1-databaseserver);
                }
                totaal = (firewall) * (DBLoader) * (1-databaseserverpercentage) * (1-webserverpercentage);
            }
        }
        return totaal;
    }
}
