/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

/**
 *
 * @author joery
 */
public class Webserver extends Server {
    public Webserver(){
        
    }
    
    public Webserver(String naam, int prijs, double beschikbaarheid){
        super(naam, prijs, beschikbaarheid); 
    }
    
    public Webserver(String naam, int prijs, double beschikbaarheid, int processorbelasting, int diskruimte){
        super(naam, prijs, beschikbaarheid, processorbelasting, diskruimte); 
    }
}
