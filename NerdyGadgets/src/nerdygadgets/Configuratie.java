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

    public Configuratie(ArrayList<Server> samenstelling) {
        this.samenstelling = samenstelling;
    }

    public ArrayList<Server> getSamenstelling() {
        return samenstelling;
    }

    // constructor die gebruikt wordt bij het maken van een nieuw ontwerp
    public Configuratie() {
        
    }
    
    public void print() {
        for(Server test: samenstelling) {
            System.out.println(test.toString());
        }
    }


 

    public void voegComponentToe(int Component, Werkveld werkveld, Server s1) {
        //Kijkt naar het meegegeven component nummer, die gekozen is in het serverkeuze dialoog, daarna voegt hij de bijbehorende server toe.
        if (Component != 0) {
            if (Component == 1) {
                this.getSamenstelling().add(s1);
            }
        }
        werkveld.lijst = this.getSamenstelling();
    }

    public void voegComponentToe(int Component, Werkveld werkveld, Server s1, Server s2, Server s3) {
        //Kijkt naar het meegegeven component nummer, die gekozen is in het serverkeuze dialoog, daarna voegt hij de bijbehorende server toe.
        if (Component != 0) {
            if (Component == 1) {
                this.getSamenstelling().add(s1);
            } else if(Component == 2) {
                this.getSamenstelling().add(s2);
            } else if(Component == 3) {
                this.getSamenstelling().add(s3);
            }                     
        werkveld.lijst = this.getSamenstelling();
        }
    }


    public ArrayList<Server> stringToComponent(ArrayList<String> ArrayStrings, Werkveld werkveld, Server ws1, Server ws2, Server ws3, Server ds1, Server ds2, Server ds3, Server firewall, Server dbbalanceloader) {
        ArrayList<Server> ArrayComponenten = new ArrayList<>();
        //Het component wordt opgehaald als string uit de database, deze methode leest de naam van de server en voegt de bijbehorende server toe. Daarna geeft hij een ArrayList met servers terug.
        for (String ComponentenString : ArrayStrings) {
            //Als het component een bepaalde naam heeft, voeg deze server aan de Componten array toe
            if (ComponentenString.contains("HAL9001W")) {
                ArrayComponenten.add(ws1);
            } else if (ComponentenString.contains("HAL9002W")) {
                ArrayComponenten.add(ws2);
            } else if (ComponentenString.contains("HAL9003W")) {
                ArrayComponenten.add(ws3);
            } else if (ComponentenString.contains("HAL9001DB")) {
                ArrayComponenten.add(ds1);
            } else if (ComponentenString.contains("HAL9002DB")) {
                ArrayComponenten.add(ds2);
            } else if (ComponentenString.contains("HAL9003DB")) {
                ArrayComponenten.add(ds3);
            } else if (ComponentenString.contains("DB loadbalancer")) {
                ArrayComponenten.add(dbbalanceloader);
            } else if (ComponentenString.contains("PFsense")) {
                ArrayComponenten.add(firewall);
            }

        }

        return ArrayComponenten;
    }

    // fucntie voor berekenen voor totaalprijs
    public int BerekenTotaalPrijs() {
        int prijs = 0;
        for (Server component : samenstelling) {
            prijs += component.getPrijs();
        }
        return prijs;
    }

    //Functie voor het berekenen van percentage
    public double BerekenPercentage() {
        ArrayList<Double> percentage = new ArrayList<>();
        ArrayList<Double> webserverlijst = new ArrayList<>();
        ArrayList<Double> databaseserverlijst = new ArrayList<>();
        double firewall = 1;
        double DBLoader = 1;
        double totaal = 1;
        int aantal = 0;

        //Hier wordt gekeken naar het type component, bij firewall en DBLoader is er altijd maar 1. Daar wordt de percentage meteen al bereken, bij web en db servers worden ze eerst in een
        //ArrayList gedaan om de percentage later te berekenen, vanwege de redundancy.
        for (Server component : samenstelling) {
            if (component instanceof Webserver) {
                webserverlijst.add(component.getBeschikbaarheid());

            } else if (component instanceof Databaseserver) {
                databaseserverlijst.add(component.getBeschikbaarheid());
            } else if (component instanceof PFsense) {
                firewall = component.getBeschikbaarheid();
            } else {
                DBLoader = component.getBeschikbaarheid();
            }

            //Update het aantal van de componenten
            aantal += 1;
        }
        //Als er 1 of minder componenten wordt het totaal meteen uitgerekend

        if (aantal <= 1) {
            for (Server component : samenstelling) {
                totaal -= 1;
                totaal += component.getBeschikbaarheid();
            }
        } else {
            //Als er geen sprake is van redundatie kan het ook meteen uitgerekend worden
            if (webserverlijst.size() <= 1 && databaseserverlijst.size() <= 1) {
                for (Server component : samenstelling) {
                    totaal *= component.getBeschikbaarheid();
                }
            } else {
                //Hier is er wel sprake van redundantie, dus hier wordt de beschikbaarheid berekent met de formule die nodig is bij redundantie
                double webserverpercentage = 1;
                double databaseserverpercentage = 1;
                for (double webserver : webserverlijst) {
                    webserverpercentage *= (1 - webserver);
                }
                for (double databaseserver : databaseserverlijst) {
                    databaseserverpercentage *= (1 - databaseserver);
                }
                //Hier wordt het totaal bereken van alle componenten ook als ze redudant geschakelt zijn
                totaal = (firewall) * (DBLoader) * (1 - databaseserverpercentage) * (1 - webserverpercentage);
            }
        }
        //Geef het totaal aantal terug
        return totaal;
    }

    public void setSamenstelling(ArrayList<Server> samenstelling) {
        this.samenstelling = samenstelling;
    }

    public void clearSamenstelling() {
        samenstelling.clear();
    }

    public void addToSamenstelling(Server server) {
        samenstelling.add(server);
    }

}
