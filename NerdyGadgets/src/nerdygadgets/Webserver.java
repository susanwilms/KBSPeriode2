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
public class Webserver extends Server {

    private ArrayList<Server> webserverArray = new ArrayList<>();

    public Webserver() {

    }

    public Webserver(String naam, int prijs, double beschikbaarheid) {
        super(naam, prijs, beschikbaarheid);
    }

    public Webserver(String naam, int prijs, double beschikbaarheid, int processorbelasting, int diskruimte) {
        super(naam, prijs, beschikbaarheid, processorbelasting, diskruimte);
    }

    public void addToWebserverArray(Server server) {
        webserverArray.add(server);
    }

    public ArrayList<Server> getWebserverArray() {
        return webserverArray;
    }
}
