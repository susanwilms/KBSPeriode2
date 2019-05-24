/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mbred
 */
public class Werkveld extends JPanel {

    public ArrayList<Server> lijst = new ArrayList<>();
    private BufferedImage webserver, dbserver, dbloadbalancer, pfsense;

    public Werkveld() {
        this.setPreferredSize(new Dimension(560, 607));
        try {
            webserver = ImageIO.read(new File("src/nerdygadgets/Webserver.png"));
            dbserver = ImageIO.read(new File("src/nerdygadgets/Databaseserver.png"));
            dbloadbalancer = ImageIO.read(new File("src/nerdygadgets/Databasebalancing.png"));
            pfsense = ImageIO.read(new File("src/nerdygadgets/Firewall.png"));
        } catch (IOException ex) {
            System.out.println("Geen afbeelding gevonden");
        }
    }

    public void paintComponent(Graphics g) {
        // teken de achtergrond
        super.paintComponent(g);

        // maak de achtergrond de goede kleur
        setBackground(new Color(204, 255, 255));

        int xwebserver = 20;
        int xdbserver = 20;
        int xdbloadbalancer = 20;
        int xpfsense = 20;
        int xstringweb = 22;
        int xstringdb = 22;
        int xstringdbload = 5;
        int xstringfirewall = 25;
        int tellerWeb = 0;
        int aantalExtraWebserver = 0;
        int tellerDatabase = 0;
        int aantalHAL9001W = 0;
        int aantalHAL9002W = 0;
        int aantalHAL9003W = 0;
        int aantalHAL9001DB = 0;
        int aantalHAL9002DB = 0;
        int aantalHAL9003DB = 0;
        for (Server component : lijst) {
            if (component instanceof Webserver) {
                if (tellerWeb < 7) {
                    g.drawImage(webserver, xwebserver, 20, this);
                    xwebserver += 75;
                    g.drawString(component.getNaam(), xstringweb, 90);
                    xstringweb += 75;
                    tellerWeb++;
                } else {
                    // g.drawRect(WIDTH, WIDTH, WIDH, HEIGHT)

                    // g.setColor(new Color(102, 255, 255));
                    g.setColor(Color.WHITE);
                    g.fillRect(xwebserver, 20, 90, 60);
                    g.setColor(Color.BLACK);
                    // g.drawRect(xwebserver, 20, 90, 60);
                    if (component.getNaam().equals("HAL9001W")) {
                        aantalHAL9001W++;
                    } else if (component.getNaam().equals("HAL9002W")) {
                        aantalHAL9002W++;
                    } else if (component.getNaam().equals("HAL9003W")) {
                        aantalHAL9003W++;
                    }
                    g.drawString("+" + aantalHAL9001W + " HAL9001W", xwebserver + 2, 35);
                    g.drawString("+" + aantalHAL9002W + " HAL9002W", xwebserver + 2, 55);
                    g.drawString("+" + aantalHAL9003W + " HAL9003W", xwebserver + 2, 75);
                }

            } else if (component instanceof DatabaseServer) {
                if (tellerDatabase < 7) {
                    g.drawImage(dbserver, xdbserver, 120, this);
                    xdbserver += 75;
                    g.drawString(component.getNaam(), xstringdb, 190);
                    xstringdb += 75;
                    tellerDatabase++;
                } else {
                    //g.setColor(new Color(102, 255, 255));
                    g.setColor(Color.WHITE);
                    g.fillRect(xdbserver, 120, 90, 60);
                    g.setColor(Color.BLACK);
                    // g.drawRect(xdbserver, 120, 90, 60);
                    if (component.getNaam().equals("HAL9001DB")) {
                        aantalHAL9001DB++;
                    } else if (component.getNaam().equals("HAL9002DB")) {
                        aantalHAL9002DB++;
                    } else if (component.getNaam().equals("HAL9003DB")) {
                        aantalHAL9003DB++;
                    }
                    g.drawString("+" + aantalHAL9001DB + " HAL9001DB", xdbserver + 2, 135);
                    g.drawString("+" + aantalHAL9002DB + " HAL9002DB", xdbserver + 2, 155);
                    g.drawString("+" + aantalHAL9003DB + " HAL9003DB", xdbserver + 2, 175);
                }

            } else if (component instanceof DBloadBalancer) {
                g.drawImage(dbloadbalancer, xdbloadbalancer, 220, this);
                xdbloadbalancer += 100;
                g.drawString(component.getNaam(), xstringdbload, 290);
                xstringdbload += 100;
            } else if (component instanceof PFsense) {
                g.drawImage(pfsense, xpfsense, 320, this);
                xpfsense += 100;
                g.drawString(component.getNaam(), xstringfirewall, 390);
                xstringfirewall += 100;
            }

        }
    }

    public void addToLijst(Server server) {
        lijst.add(server);
    }

    public void clearLijst() {
        lijst.clear();
    }
}
