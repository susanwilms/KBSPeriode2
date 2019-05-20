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
public class FysiekComponent {

    private String naam;
    private int prijs;
    private double beschikbaarheid;
    private int beschikbareTijd;
    private int processorbelasting;
    private int diskruimte;

    // constructor om een server mee aan te maken wanneer alleen de naam, prijs en beschikbaarheid beschikbaar is.
    public FysiekComponent(String naam, int prijs, double beschikbaarheid) {
        this.naam = naam;
        this.prijs = prijs;
        this.beschikbaarheid = beschikbaarheid;
        this.beschikbareTijd = 0;
        this.processorbelasting = 0;
        this.diskruimte = 0;
    }

    // constructor(overloading) om een server mee aan te maken wanneer alleen de naam, prijs, beschikbaarheid, processorbelasting en diskruimte beschikbaar zijn.
    public FysiekComponent(String naam, int prijs, double beschikbaarheid, int processorbelasting, int diskruimte) {
        this.naam = naam;
        this.prijs = prijs;
        this.beschikbaarheid = beschikbaarheid;
        this.beschikbareTijd = 0;
        this.processorbelasting = processorbelasting;
        this.diskruimte = diskruimte;
    }

    public FysiekComponent() {

    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public void setBeschikbaarheid(double beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }

    public void setBeschikbareTijd(int beschikbareTijd) {
        this.beschikbareTijd = beschikbareTijd;
    }

    public void setProcessorbelasting(int processorbelasting) {
        this.processorbelasting = processorbelasting;
    }

    public void setDiskruimte(int diskruimte) {
        this.diskruimte = diskruimte;
    }

}
