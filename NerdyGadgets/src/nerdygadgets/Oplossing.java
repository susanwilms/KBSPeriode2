/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.util.ArrayList;

/**
 *
 * @author joery
 */
public class Oplossing {
    private ArrayList<Server> besteOplossing = new ArrayList<Server>();
    private ArrayList<Server> huidigeOplossing;
    private Webserver besteWebserver;
    private DatabaseServer besteDbserver;
    private ArrayList<Server> webserverArray;
    private ArrayList<Server> dbserverArray;
    private PFsense pfsense;
    private DBloadBalancer dbloadbalancer;
    private double beschikbaarheidDoel;
    private int prijsBesteOplossing = 2000000;
    
    
    public Oplossing(   Webserver ws1, Webserver ws2, Webserver ws3,
                        DatabaseServer ds1, DatabaseServer ds2, DatabaseServer ds3,
                        PFsense pfsense, DBloadBalancer dbloadbalancer, double beschikbaarheidDoel){
        webserverArray = new ArrayList<>();
            webserverArray.add(ws1);
            webserverArray.add(ws2);
            webserverArray.add(ws3);
        
        dbserverArray = new ArrayList<>();
            dbserverArray.add(ds1);
            dbserverArray.add(ds2);
            dbserverArray.add(ds3);
        
        
        
        this.pfsense = pfsense;
        this.dbloadbalancer = dbloadbalancer;
        this.beschikbaarheidDoel = beschikbaarheidDoel;
        prijsBesteOplossing = 0;
    }
    
    public double berekenBeschikbaarheidWebservers(ArrayList<Server> oplossing){
        double beschikbaarheid = 1;
        for(Server server : oplossing){
            if(server instanceof Webserver){
                beschikbaarheid *= (1 - server.getBeschikbaarheid());
            }
        }
        return (1 - beschikbaarheid);
    }
    
    public double berekenBeschikbaarheidDbservers(ArrayList<Server> oplossing){
        double beschikbaarheid = 1;
        for(Server server : oplossing){
            if(server instanceof DatabaseServer){
                beschikbaarheid *= (1 - server.getBeschikbaarheid());
            }
        }
        return (1 - beschikbaarheid);
    }
        
    
    public double berekenTotaleBeschikbaarheid(ArrayList<Server> oplossing){
        double beschikbaarheidPFsense = 0;
        double beschikbaarheidDbloadbalancer = 0 ;
        for(Server server : oplossing){
            if(server instanceof PFsense){
                beschikbaarheidPFsense = server.getBeschikbaarheid();
            }
            if(server instanceof DBloadBalancer){
                beschikbaarheidDbloadbalancer = server.getBeschikbaarheid();
            }
        }
        return(berekenBeschikbaarheidWebservers(oplossing) * berekenBeschikbaarheidDbservers(oplossing) 
                * beschikbaarheidPFsense * beschikbaarheidDbloadbalancer);
    }
    
    public int berekenPrijs(ArrayList<Server> oplossing){
        int prijs = 0;
        for(Server server : oplossing){
            prijs += server.getPrijs();
        }
        return prijs;
    }
    
    public  void berekenBesteOplossing(ArrayList<Server> oplossing, ArrayList<Server> servers){
        ArrayList<Server> huidigeBesteOplossing = new ArrayList<>();
        if(oplossing.isEmpty()){
           oplossing.add(pfsense);
           oplossing.add(dbloadbalancer);
       }
       
        for(Server server : servers){
           oplossing.add(server);
//voldoet de oplossing
           if((berekenTotaleBeschikbaarheid(oplossing) >= beschikbaarheidDoel && berekenPrijs(oplossing) < berekenPrijs(huidigeBesteOplossing) )|| berekenPrijs(huidigeBesteOplossing) == 0){
               System.out.println("-----------------------------------------OPLOSSING VOLDOET------------------------------------");
               huidigeBesteOplossing = oplossing;
           }
           else if (berekenTotaleBeschikbaarheid(oplossing) < beschikbaarheidDoel){
               if(berekenBeschikbaarheidWebservers(oplossing) < berekenBeschikbaarheidDbservers(oplossing)){
                   System.out.println("-----------------------------------------------TOEVOEGEN WEBSERVER!-------------------------------------");
                   berekenBesteOplossing(oplossing, webserverArray);
               } else {
                   berekenBesteOplossing(oplossing, dbserverArray);
                   System.out.println("-----------------------------------------------TOEVOEGEN DBSERVER!-------------------------------------");
               }
           } 
           else if (berekenPrijs(oplossing) > berekenPrijs(huidigeBesteOplossing) && berekenPrijs(huidigeBesteOplossing) != 0){
               System.out.println("-----------------------------------------------OPLOSSING TE DUUR!-------------------------------------");
           }
           oplossing.remove(oplossing.size()-1);
       }
        //return huidigeBesteOplossing;
    }
    
    public ArrayList<Server> getOplossing(){
        //berekenBesteOplossing(besteOplossing);
        return besteOplossing;
    }
}
