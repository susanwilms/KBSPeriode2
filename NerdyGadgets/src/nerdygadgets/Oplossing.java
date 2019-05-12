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
    private Webserver a;
    private Webserver b;
    private Webserver c;
    private DatabaseServer d;
    private DatabaseServer e;
    private DatabaseServer f;
    private PFsense g;
    private DBloadBalancer h;
    

    public Oplossing(Webserver a, Webserver b, Webserver c, DatabaseServer d, DatabaseServer e, DatabaseServer f, PFsense g, DBloadBalancer h) {
        //Databaseservers en webservers worden toegevoegd.
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
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

    public ArrayList<Server> berekenGoedkoopsteOplossing() {

        double beschikbaarheidOplossing = 0;
        double beschikbaarheidDoel = 0.9999;
        int prijsOplossing = 0;
        int prijsBesteOplossing = 0;
        int index = 0; //hierdoor wordt de juiste webserver toegevoegd
        int teller = 0 ; 
        boolean isVerwijderd = false;

        Webserver besteWebserver = null; //Webserver met de hoogste beschikbaarheid
        DatabaseServer besteDatabaseServer = null;  //Databaseserver met de hoogste beschikbaarheid
for (Webserver wb : webservers) {
                    
                    double beschikbaarheid = 0; //deze variabele voorkomt nullpointer in de if-loop (rgl 48), deze variabele wordt overgeschreven in de loop
                    if (wb.getBeschikbaarheid() > beschikbaarheid) {
                        besteWebserver = wb;
                        beschikbaarheid = besteWebserver.getBeschikbaarheid();
                    }
                }
for (DatabaseServer ds : dbservers) {
                    double beschikbaarheid = 0;
                    if (ds.getBeschikbaarheid() > beschikbaarheid) {
                        besteDatabaseServer = ds;
                        beschikbaarheid = besteDatabaseServer.getBeschikbaarheid();
                    }
                }
                double beschikbaarheid = 0 ;
        //Er wordt een waarde berekent voor de gestelde beschikbaarheid
        while (berekenBeschikbaarheid(besteOplossing) < beschikbaarheidDoel) {
            System.out.println(berekenBeschikbaarheid(besteOplossing));
            System.out.println("web: " + berekenBeschikbaarheidWebservers(besteOplossing));
            System.out.println("data: " + berekenBeschikbaarheidWebservers(besteOplossing));
            if (berekenBeschikbaarheidWebservers(besteOplossing) < berekenBeschikbaarheidDbservers(besteOplossing)) {
                besteOplossing.add(besteWebserver);
               beschikbaarheid = berekenBeschikbaarheid(besteOplossing);
            } else {
                besteOplossing.add(besteDatabaseServer);
                
            }
        }
       /* prijsBesteOplossing = berekenPrijs(besteOplossing); */

        /*Nu moet de beste/goedkoopste oplossing worden berekent. Voor uitleg van deze code of pseudocode zie het technisch ontwerp*/
        /*while (berekenBeschikbaarheid(huidigeOplossing) < berekenBeschikbaarheid(besteOplossing) && berekenPrijs(huidigeOplossing) < berekenPrijs(besteOplossing) && teller < 25) {
            if (berekenBeschikbaarheidWebservers(huidigeOplossing) < berekenBeschikbaarheidDbservers(huidigeOplossing)) {
                while (index >= webservers.size() - 1) {
                    //vorige webserver moet worden verwijderd
                    for (int i = huidigeOplossing.size() - 1; i > 0; i--) {
                        Server server = huidigeOplossing.get(i);
                        if (server instanceof Webserver) {
                            //De eerste webserver moet worden verwijderd en de for-loop (rgl 83) moet worden verlaten
                            huidigeOplossing.remove(i);
                            index = i;
                            break;
                        }
                    }
                    isVerwijderd = true;
                }
                //De webserver die als index de waarde van de variabele index + 1 heeft moet worden toegevoegd
                if (isVerwijderd) {
                    huidigeOplossing.add(webservers.get(index + 1));
                } else {
                    huidigeOplossing.add(webservers.get(index));
                }
                //Als de oplossing voldoet aan de eisen wordt de prijs en oplossing worden opgeslagen.
                if(berekenBeschikbaarheid(huidigeOplossing) >= berekenBeschikbaarheid(besteOplossing) && berekenPrijs(huidigeOplossing) < berekenPrijs(besteOplossing)){ 
                    besteOplossing = huidigeOplossing;
                    huidigeOplossing.clear();
                    huidigeOplossing.add(PFsense);
                    huidigeOplossing.add(DBloadbalancer);
                } else if(berekenPrijs(huidigeOplossing) > berekenPrijs(besteOplossing)){
                    //De webserver moet worden verwijderd en de index moet worden opgeslagen
                    for (int i = huidigeOplossing.size() - 1; i > 0; i--) {
                        Server server = huidigeOplossing.get(i);
                        if (server instanceof Webserver) {
                            //De eerste webserver moet worden verwijderd en de for-loop (rgl 110) moet worden verlaten
                            huidigeOplossing.remove(i);
                            index = i;
                            break;
                        }
                    }
                } else {
                    isVerwijderd = false;
                }
            } else {
                while (index >= dbservers.size() - 1) {
                    //vorige databaseserver moet worden verwijderd
                    for (int i = huidigeOplossing.size() - 1; i > 0; i--) {
                        Server server = huidigeOplossing.get(i);
                        if (server instanceof DatabaseServer) {
                            //De eerste databaseserver moet worden verwijderd en de for-loop (rgl 83) moet worden verlaten
                            huidigeOplossing.remove(i);
                            index = i;
                            break;
                        }
                    }
                    isVerwijderd = true;
                }
                //De databaseserver die als index de waarde van de variabele index + 1 heeft moet worden toegevoegd
                if (isVerwijderd) {
                    huidigeOplossing.add(dbservers.get(index + 1));
                } else {
                    huidigeOplossing.add(dbservers.get(index));
                }
                //Als de oplossing voldoet aan de eisen wordt de prijs en oplossing worden opgeslagen.
                if(berekenBeschikbaarheid(huidigeOplossing) >= berekenBeschikbaarheid(besteOplossing) && berekenPrijs(huidigeOplossing) < berekenPrijs(besteOplossing)){ 
                    besteOplossing = huidigeOplossing;
                    huidigeOplossing.clear();
                    huidigeOplossing.add(PFsense);
                    huidigeOplossing.add(DBloadbalancer);
                } else if(berekenPrijs(huidigeOplossing) > berekenPrijs(besteOplossing)){
                    //De webserver moet worden verwijderd en de index moet worden opgeslagen
                    for (int i = huidigeOplossing.size() - 1; i > 0; i--) {
                        Server server = huidigeOplossing.get(i);
                        if (server instanceof DatabaseServer) {
                            //De eerste webserver moet worden verwijderd en de for-loop (rgl 110) moet worden verlaten
                            huidigeOplossing.remove(i);
                            index = i;
                            break;
                        }
                    }
                } else {
                    isVerwijderd = false;
                }
            }
            teller++;
        } */
        return besteOplossing;
    } 

    public int berekenPrijs(ArrayList<Server> oplossing) {
        int prijs = 0;
        for (Server server : oplossing) {
            prijs += server.getPrijs();
        }
        return prijs;
    }

    public double berekenBeschikbaarheidWebservers(ArrayList<Server> servers) {
        double beschikbaarheidWebservers = 1;
        for (Server server : servers) {
            if (server instanceof Webserver) {
                beschikbaarheidWebservers *= (1 - server.getBeschikbaarheid());
            }
        }
        return (1 - beschikbaarheidWebservers);
    }

    public double berekenBeschikbaarheidDbservers(ArrayList<Server> servers) {
        double beschikbaarheidDbServers = 1;
        for (Server server : servers) {
            if(server instanceof DatabaseServer){
                beschikbaarheidDbServers *= (1 - server.getBeschikbaarheid());
            }
        }
        return (1 - beschikbaarheidDbServers);
    }

    public double berekenBeschikbaarheid(ArrayList<Server> oplossing) {
        double beschikbaarheidWeb = berekenBeschikbaarheidWebservers(oplossing);
        double beschikbaarheidData = berekenBeschikbaarheidDbservers(oplossing);
        double beschikbaarheidPFsense = PFsense.getBeschikbaarheid();
        double beschikbaarheidDBloadbalancer = DBloadbalancer.getBeschikbaarheid();
        
        return beschikbaarheidWeb * beschikbaarheidData * beschikbaarheidPFsense * beschikbaarheidDBloadbalancer;
    }
}
