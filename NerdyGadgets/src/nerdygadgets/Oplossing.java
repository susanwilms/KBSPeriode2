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
    private ArrayList<Server>   besteOplossing = new ArrayList<Server>();
    private ArrayList<Server>   uiteindelijkeOplossing = new ArrayList<>();
    private Webserver           besteWebserver;
    private DatabaseServer      besteDbserver;
    private ArrayList<Server>   webserverArray;
    private ArrayList<Server>   dbserverArray;
    private PFsense             pfsense;
    private DBloadBalancer      dbloadbalancer;
    private double              beschikbaarheidDoel;
    private int                 prijsBesteOplossing;
    private double              percentageWebServers;
    private double              percentageDatabaseServers;
    
    
    public Oplossing(   Webserver ws1, Webserver ws2, Webserver ws3,
                        DatabaseServer ds1, DatabaseServer ds2, DatabaseServer ds3,
                        PFsense pfsense, DBloadBalancer dbloadbalancer, double beschikbaarheidDoel){
        
        // ArrayList met alle webservers maken
        webserverArray          = new ArrayList<>();
            webserverArray      .add(ws1);
            webserverArray      .add(ws2);
            webserverArray      .add(ws3);
        
        // ArrayList met alle databaseservers maken
        dbserverArray           = new ArrayList<>();
            dbserverArray       .add(ds1);
            dbserverArray       .add(ds2);
            dbserverArray       .add(ds3);
         
        // Overige componenten toevoegen
        this.pfsense            = pfsense;
        this.dbloadbalancer     = dbloadbalancer;
        this.beschikbaarheidDoel= beschikbaarheidDoel;
        prijsBesteOplossing     = 0;
    }
    
    // Functie om de beschikbaarheid van de webservers te berekenen 
    public double berekenBeschikbaarheidWebservers(ArrayList<Server> oplossing){
        // variabele beschikbaarheid aanmaken
        double beschikbaarheid = 1;
        // for loop iedere server in de oplossing in de formule te verwerken
        for(Server server : oplossing){
            if(server instanceof Webserver){
                // gegeven formule uit de reader
                beschikbaarheid *= (1 - server.getBeschikbaarheid());
            }
        }
        // beschikbaarheid min 1 doen omdat dit niet in de for loop gedaan kan worden
        beschikbaarheid = 1 - beschikbaarheid;
        // het antwoord (beschikbaarheid) returnen
        return (beschikbaarheid);
    }
    
    // functie om de beschikbaarheid van de databaseservers te berekenen
    public double berekenBeschikbaarheidDbservers(ArrayList<Server> oplossing){
        // variabele beschikbaarheid aanmaken
        double beschikbaarheid = 1;
        // for loop iedere server in de oplossing in de formule te verwerken
        for(Server server : oplossing){
            if(server instanceof DatabaseServer){
                // gegeven formule uit de reader
                beschikbaarheid *= (1 - server.getBeschikbaarheid());
            }
        }
        // beschikbaarheid min 1 doen omdat dit niet in de for loop gedaan kan worden
        beschikbaarheid = 1 - beschikbaarheid;
        // het antwoord (beschikbaarheid) returnen
        return (beschikbaarheid);
    }
        
    // Functie om de totale beschikbaarheid van de oplossing te berekenen 
    // gebruikt de arraylist met daarin de oplossing 
    public double berekenTotaleBeschikbaarheid(ArrayList<Server> oplossing){
        // inititialiseren PFsense en DBloadbalancer
        double beschikbaarheidPFsense = 0;
        double beschikbaarheidDbloadbalancer = 0 ;
        for(Server server : oplossing){
            if(server instanceof PFsense){
                // beschikbaarheid van de PFsense ophalen
                beschikbaarheidPFsense = server.getBeschikbaarheid();
            }
            if(server instanceof DBloadBalancer){
                // beschikbaarheid van de dbloadbalancer ophalen
                beschikbaarheidDbloadbalancer = server.getBeschikbaarheid();
            }
        }
        // de uitkomst van de formule teruggeven die de totale beschikbaarheid uitrekent
        return(berekenBeschikbaarheidWebservers(oplossing) * berekenBeschikbaarheidDbservers(oplossing) 
                * beschikbaarheidPFsense * beschikbaarheidDbloadbalancer);
    }
    
    // functie om de prijs te berekenen 
    public int berekenPrijs(ArrayList<Server> oplossing){
        // de variabele prijs initialiseren
        int prijs = 0;
        // for loop op de prijzen van alle items in de array oplossing bij elkaar op te tellen
        for(Server server : oplossing){
            prijs += server.getPrijs();
        }
        // de prijs teruggeven
        return prijs;
    }
    
    // Functie om de beste oplossing te berekenen (recursieve backtracking)
    public  void berekenBesteOplossing(ArrayList<Server> oplossing, ArrayList<Server> servers){
        // de PFsense en DBloadbalancer toevoegen als de oplossing helemaal leeg is
        if(oplossing.isEmpty()){
           oplossing.add(pfsense);
           oplossing.add(dbloadbalancer);
        }
        // Hiermee gaat hij elke server in de arraylist na dus elke database of webserver wordt bekeken.
        for(Server server : servers){
           oplossing.add(server);
           
            // voldoet de oplossing?
            // is de beschikbaarheid van de oplossing groter dan of gelijk aan het doel EN is de prijs goedkoper dan die van de vorige beste oplossing? 
           if(berekenTotaleBeschikbaarheid(oplossing) >= beschikbaarheidDoel && (berekenPrijs(oplossing) < prijsBesteOplossing ||prijsBesteOplossing == 0)){
             System.out.println("-----------------------------------------OPLOSSING VOLDOET------------------------------------");
             System.out.println("totale beschikbaarheid: " + berekenTotaleBeschikbaarheid(oplossing));
             // De ArrayList met de uiteindelijke oplossing leegmaken omdat hier nog items van de vorige oplossing in staan 
             uiteindelijkeOplossing.clear();
                   System.out.println("beschikbaarheid webservers " + percentageWebServers);
                   System.out.println("beschikbaarheid databaseservers " + percentageDatabaseServers);
                   // De items van de nieuwe oplossing in de ArrayList uiteindelijkeOplossing zetten
                   for(Server server2 : oplossing){
                      System.out.println(server2.getNaam());
                      uiteindelijkeOplossing.add(server2);
                   }
               // de prijs berekenen 
               prijsBesteOplossing = berekenPrijs(oplossing);
           }
           
           // is de beschikbaarheid van de oplossing kleiner dan het minimale doel dat we willen?
           else if (berekenTotaleBeschikbaarheid(oplossing) < beschikbaarheidDoel){
               // kiezen of webserver / databaseserver wordt toegevoegd
               // percentage van de webservers laten uitrekenen
               percentageWebServers = berekenBeschikbaarheidWebservers(oplossing);
               // percentage van de databaseservers laten uitrekenen
               percentageDatabaseServers = berekenBeschikbaarheidDbservers(oplossing);
               // als het beschikbaarheidspercentage van de databaseservers hoger is dan ie van de webserservers
               if(percentageWebServers < percentageDatabaseServers){
                   // webserver toevoegen aan de webserverarray
                   berekenBesteOplossing(oplossing, webserverArray);
               // als het beschikbaarheidspercentage van de webservers hoger is dan ie van de databaseserservers
               } else {
                   // databaseserver toevoegen aan de dbserverArray
                   berekenBesteOplossing(oplossing, dbserverArray);                   
               }
           } 
           
           // is de prijs hogter dan de prijs van de tot nu toe beste oplossing (en niet gelijk aan nul)?
           else if (berekenPrijs(oplossing) > prijsBesteOplossing && prijsBesteOplossing != 0){
           // niets doen omdat de oplossing te duur is, hij gaat dan automatisch opnieuw in de loop. 
           }
           // de oplossing verwijderen
           oplossing.remove(oplossing.size()-1);
       }
        
    }
    
    // functie om de oplossing te getten
    public ArrayList<Server> getOplossing(){
        // de uiteindelijke (definitieve) oplossing returnen 
        return uiteindelijkeOplossing;
    }
}
