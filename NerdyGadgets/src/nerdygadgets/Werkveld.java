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
    private BufferedImage webserver, dbserver, dbbalanceloader, firewall;

    public Werkveld() {
        this.setPreferredSize(new Dimension(560, 607));
        try {
            webserver = ImageIO.read(new File("src/nerdygadgets/Webserver.png"));
            dbserver = ImageIO.read(new File("src/nerdygadgets/Databaseserver.png"));
            dbbalanceloader = ImageIO.read(new File("src/nerdygadgets/Databasebalancing.png"));
            firewall = ImageIO.read(new File("src/nerdygadgets/Firewall.png"));
        } catch (IOException ex) {
            System.out.println("Plaatje niet gevonden.");
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

        for (Server component : lijst) {
            if (component instanceof Webserver) {
                g.drawImage(webserver, xwebserver, 20, this);
                xwebserver += 100;
                g.drawString(component.getNaam(), xstringweb, 90);
                xstringweb += 100;
            } else if (component instanceof DatabaseServer) {
                g.drawImage(dbserver, xdbserver, 120, this);
                xdbserver += 100;
                g.drawString(component.getNaam(), xstringdb, 190);
                xstringdb += 100;
            } else if (component instanceof DBloadBalancer) {
                g.drawImage(dbbalanceloader, xdbloadbalancer, 220, this);
                xdbloadbalancer += 100;
                g.drawString(component.getNaam(), xstringdbload, 290);
                xstringdbload += 100;
            } else if (component instanceof PFsense) {
                g.drawImage(firewall, xpfsense, 320, this);
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
