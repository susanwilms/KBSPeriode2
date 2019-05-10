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
    private ArrayList<Server> besteOplossing = new ArrayList<>();
    private ArrayList<Server> huidigeOplossing = new ArrayList<>();
    private ArrayList<Webserver> webservers = new ArrayList<>();
    private ArrayList<DatabaseServer> dbservers = new ArrayList<>();
    private PFsense PFsense;
    private DBloadBalancer DBloadbalancer;
    
    public Oplossing(Webserver a, Webserver b, Webserver c, DatabaseServer d, DatabaseServer e, DatabaseServer f,PFsense g, DBloadBalancer h){
        //Databaseservers en webservers worden toegevoegd.
        webservers.add(a);
        webservers.add(b);
        webservers.add(c);
        dbservers.add(d);
        dbservers.add(e);
        dbservers.add(f);
        
        besteOplossing.add(g);
        besteOplossing.add(h);
        
        huidigeOplossing.add(g);
        huidigeOplossing.add(h);
        
        PFsense = g;
        DBloadbalancer = h;
        
    }
    
    public ArrayList<Server> berekenGoedkoopsteOplossing(){
        
        double beschikbaarheidOplossing = 0;
        double beschikbaarheidDoel = 0.9999 ;
        int prijsOplossing = 0 ; 
        int prijsBesteOplossing = 0 ;
        
        Webserver besteWebserver = null ; //Webserver met de hoogste beschikbaarheid
        DatabaseServer besteDatabaseServer = null ;  //Databaseserver met de hoogste beschikbaarheid
        
        //Er wordt een waarde berekent voor de gestelde beschikbaarheid
        while(beschikbaarheidOplossing < beschikbaarheidDoel){
            if (this.berekenBeschikbaarheidWebservers(besteOplossing) < this.berekenBeschikbaarheidDbservers(besteOplossing)){
                for (Webserver wb : webservers){
                    double beschikbaarheid = 0; //deze variabele voorkomt nullpointer in de if-loop (rgl 48), deze variabele wordt overgeschreven in de loop
                    if (wb.getBeschikbaarheid() > beschikbaarheid){
                        besteWebserver = wb;
                        beschikbaarheid = besteWebserver.getBeschikbaarheid();
                    }
                }
                besteOplossing.add(besteWebserver);
                
             } else {
                for (DatabaseServer ds : dbservers){
                    double beschikbaarheid = 0;
                    if (ds.getBeschikbaarheid() > beschikbaarheid){
                        besteDatabaseServer = ds;
                        beschikbaarheid = besteDatabaseServer.getBeschikbaarheid();
                    }
                }
                besteOplossing.add(besteDatabaseServer);
            }
        }
        prijsBesteOplossing = this.berekenPrijs(besteOplossing);
        
        return besteOplossing;
    }
    
    public int berekenPrijs(ArrayList<Server> oplossing){
        int prijs = 0;
        for(Server server : oplossing){
            prijs += server.getPrijs();
        }
        return prijs;
    }
    
    public double berekenBeschikbaarheidWebservers(ArrayList<Server> servers ){
        double beschikbaarheidWebservers = 0;
        for(Server server : servers){
            if( server instanceof Webserver){
                beschikbaarheidWebservers *= 1 - server.getBeschikbaarheid();
            }
        }
        return (1 - beschikbaarheidWebservers);
    }
    
    public double berekenBeschikbaarheidDbservers(ArrayList<Server> servers ){
        double beschikbaarheidDbServers = 1;
        for(DatabaseServer dbserver : dbservers){
            beschikbaarheidDbServers *= (1 - dbserver.getBeschikbaarheid());
        }
        return 1-beschikbaarheidDbServers;
    }
    
    public double berekenBeschikbaarheid(ArrayList<Server> oplossing){
        double beschikbaarheidWeb = 1;
        double beschikbaarheidData = 1;
        double beschikbaarheidPFsense = 0;
        double beschikbaarheidDBloadbalancer = 0;
        double totaleBeschikbaarheid = 0;
        
        for (Server server : oplossing){
            if(server instanceof Webserver){
                beschikbaarheidWeb *= 1-server.getBeschikbaarheid();
            }
            if(server instanceof DatabaseServer){
                beschikbaarheidData *= 1 - server.getBeschikbaarheid();
            }
            if(server instanceof PFsense){
                beschikbaarheidPFsense = server.getBeschikbaarheid();
            }
            if(server instanceof DBloadBalancer){
                beschikbaarheidDBloadbalancer = server.getBeschikbaarheid();
            }
        }
        beschikbaarheidWeb = 1 - beschikbaarheidWeb;
        beschikbaarheidData = 1 - beschikbaarheidData;
        totaleBeschikbaarheid = beschikbaarheidWeb * beschikbaarheidData * beschikbaarheidPFsense * beschikbaarheidDBloadbalancer;
        return totaleBeschikbaarheid;
    }
    
    public ArrayList<Server> getOplossing() {
        return besteOplossing;
    }
}
