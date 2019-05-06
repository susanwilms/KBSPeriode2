/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

/**
 *
 * @author susanwilms
 */
public class Server {
    // Variabelen declareren 
    private String  naam;
    private int     prijs;
    private double  beschikbaarheid;
    private int     beschikbare_tijd;
    private int     processorbelasting;
    private int     diskruimte;
    
    // constructor om een server mee aan te maken wanneer alleen de naam, prijs en beschikbaarheid beschikbaar is. 
    public Server (String naam, int prijs, double beschikbaarheid){
        this.naam               = naam;
        this.prijs              = prijs;
        this.beschikbaarheid    = beschikbaarheid;
        this.beschikbare_tijd   = 0;
        this.processorbelasting = 0;
        this.diskruimte         = 0;        
    }
    
    // constructor(overloading) om een server mee aan te maken wanneer alleen de naam, prijs, beschikbaarheid, processorbelasting en diskruimte beschikbaar zijn. 
    public Server (String naam, int prijs, double beschikbaarheid, int processorbelasting, int diskruimte){
        this.naam               = naam;
        this.prijs              = prijs;
        this.beschikbaarheid    = beschikbaarheid;
        this.beschikbare_tijd   = 0;
        this.processorbelasting = processorbelasting;
        this.diskruimte         = diskruimte; 
    }
    
    // getters
    public String getNaam() {
        return naam;
    }

    public int getPrijs() {
        return prijs;
    }
    
    public double getBeschikbaarheid(){
        return beschikbaarheid;
    }
    
}
