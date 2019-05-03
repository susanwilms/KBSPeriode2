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
public class Configuratie extends Server{
    // variabelen voor configuratie
    private ArrayList samenstelling;
    private double percentageDoei;
    
    // constructor met super() voor de server class
    public Configuratie(double percentageDoei){
        super("", 2, 2.5);
        this.percentageDoei = percentageDoei;
    }
    
    // functie berekening
    public int Berekening(){
        // pseudocode
        return 2;
    }
    
    // fucntie voor berekenen voor totaalprijs
    public int BerekenTotaalPrijs(){
        // pseudocode
        return 2;
    }
}
