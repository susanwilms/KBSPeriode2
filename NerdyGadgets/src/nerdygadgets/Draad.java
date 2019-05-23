/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import com.jcraft.jsch.JSchException;
import java.io.IOException;

/**
 *
 * @author mbred
 */
 public class Draad extends Thread {
     FysiekComponent server; 
             
  public Draad(String threadName, FysiekComponent server, String ip) { // constructor
    super(threadName);
    this.server = server;
    

  }
  public void run(){
      try{
      while(true) {
          Connection toServer = new Connection("1", "200" ,"1");
          String time = toServer.runCommand("time");
          String cpu = toServer.runCommand("cpu");
          String disk = toServer.runCommand("disk");
          toServer.close();
          System.out.println(cpu);
          System.out.println(time);
          System.out.println(disk);
          server.setBeschikbareTijd(time);
          server.setProcessorbelasting(cpu);
          server.setDiskruimte(disk);
          Thread.sleep(15000);
          
      }
      } catch(InterruptedException e) {
         
      } catch(JSchException e) {
          
      } catch(IOException ee) {
              
      }
      
}
}
