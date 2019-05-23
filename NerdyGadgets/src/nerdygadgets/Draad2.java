/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package nerdygadgets;

import com.jcraft.jsch.JSchException;
import java.io.IOException;
import javax.swing.JPanel;

 public class Draad2 extends Thread {
     FysiekComponent server;
     MonitoringBlok blok;

public Draad2(String threadName, FysiekComponent server, MonitoringBlok blok) { 
    super(threadName);
    this.server = server;
    this.blok = blok;
    

  }
  public void run(){

      while(true) {
          blok.getProcessor().setText("Processorbelasting: " + server.getProcessorbelasting() + "%");
          blok.getTijd().setText("Uptime: " + server.getBeschikbareTijd());
          blok.getDisk().setText("Diskruimte: " + server.getDiskruimte() + "%");
              
      }
      
}
}


