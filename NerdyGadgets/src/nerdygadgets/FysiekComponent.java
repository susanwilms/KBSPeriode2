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

    private double beschikbaarheid;
    private String beschikbareTijd;
    private String processorbelasting;
    private String diskruimte;

    // constructor om een server mee aan te maken wanneer alleen de naam, prijs en beschikbaarheid beschikbaar is.


    public FysiekComponent() {

    }


    public void setBeschikbaarheid(double beschikbaarheid) {
        this.beschikbaarheid = beschikbaarheid;
    }

    public void setBeschikbareTijd(String beschikbareTijd) {
        this.beschikbareTijd = beschikbareTijd;
    }

    public void setProcessorbelasting(String processorbelasting) {
        this.processorbelasting = processorbelasting;
    }

    public void setDiskruimte(String diskruimte) {
        this.diskruimte = diskruimte;
    }

    public double getBeschikbaarheid() {
        return beschikbaarheid;
    }

    public String getBeschikbareTijd() {
        return beschikbareTijd;
    }

    public String getProcessorbelasting() {
        return processorbelasting;
    }

    public String getDiskruimte() {
        return diskruimte;
    }

}
