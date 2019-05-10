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
    
    public void voegComponentToe(int Component,Werkveld werkveld, Server s1, Server s2, Server s3) {
        if(Component != 0) {
            if(Component == 1) {
                this.getSamenstelling().add(s1);
                werkveld.lijst.add(s1);
            } else if(Component == 2) {
                this.getSamenstelling().add(s2);
                werkveld.lijst.add(s2);
            } else if(Component == 3) {
                this.getSamenstelling().add(s3);
                werkveld.lijst.add(s3);
            }
        } 
    }
    
    public ArrayList<Server> stringToComponent(ArrayList<String> ArrayStrings,Werkveld werkveld, Server ws1, Server ws2, Server ws3, Server ds1, Server ds2, Server ds3, Server firewall, Server dbbalanceloader) {
        ArrayList<Server> ArrayComponenten = new ArrayList<>();
        for(String ComponentenString: ArrayStrings) {
            if(ComponentenString.contains("HAL9001W")) {
                    ArrayComponenten.add(ws1);
            }   else if(ComponentenString.contains("HAL9002W")) {
                    ArrayComponenten.add(ws2);
            }   else if(ComponentenString.contains("HAL9003W")) {
                    ArrayComponenten.add(ws3);
            }   else if(ComponentenString.contains("HAL9001DB")) {
                    ArrayComponenten.add(ds1);
            }   else if(ComponentenString.contains("HAL9002DB")) {
                    ArrayComponenten.add(ds2);
            }   else if(ComponentenString.contains("HAL9003DB")) {
                    ArrayComponenten.add(ds3);
            }   else if(ComponentenString.contains("DBloadbalancer")) {
                    ArrayComponenten.add(dbbalanceloader);
            }   else if(ComponentenString.contains("Pfsense")) {
                    ArrayComponenten.add(firewall);
            }

            }
        
        return ArrayComponenten;
    }
    
    public void voegComponentToe(int Component,Werkveld werkveld, Server s1) {
        if(Component != 0) {
            if(Component == 1) {
                this.getSamenstelling().add(s1);
                werkveld.lijst.add(s1);
            }
        }
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
