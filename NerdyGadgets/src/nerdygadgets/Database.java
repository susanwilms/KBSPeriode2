 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author mbred
 */
public class Database {
    
    public ArrayList<String> getComponenten(int OntwerpID) {
        ArrayList<String> Samenstelling = new ArrayList<>();
        try{ 
        System.out.println(OntwerpID);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
        Statement myStmt = conn.createStatement();
        
        ResultSet myRs = myStmt.executeQuery("Select * from ontwerpcomponent WHERE Ontwerpid = " + OntwerpID);
        
        while (myRs.next()) {
           Samenstelling.add(myRs.getString("Component"));

        }        
        
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return Samenstelling;
    }
    
    public int naamToId(String naam) {
        int ontwerpid = 0;
        try{ 
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
        Statement myStmt = conn.createStatement();
        
        ResultSet myRs = myStmt.executeQuery("Select * from ontwerp");
            
            while (myRs.next()) {
                if(myRs.getString("Naam").equals(naam)){
                ontwerpid = Integer.parseInt(myRs.getString("OntwerpID"));
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
    }
        return ontwerpid;
    }
    
    
    public ArrayList<String> ontwerpenOphalen() {
       ArrayList<String> Ontwerpnamen = new ArrayList<>();
       try{ 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
            Statement myStmt = conn.createStatement();
           
            ResultSet myRs = myStmt.executeQuery("Select Naam from ontwerp");
             
            
            
            while (myRs.next()) {
                Ontwerpnamen.add(myRs.getString("Naam"));            
            }
            
           
        } catch (Exception exc) {
            exc.printStackTrace();
        }
       return Ontwerpnamen;
    }
    
    public void insertinto(Double Beschikbaarheid, int prijs, String naam, ArrayList<Server> samenstelling) {   
        int ontwerpid = 0;
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
            Statement myStmt = conn.createStatement();
//            myStmt.executeUpdate("INSERT INTO ontwerp (Beschikbaarheidspercentage, Prijs, Naam, Opslag) VALUES (" ''+ Beschikbaarheid +' ", " + prijs + ", " + naam +  ")");
              Calendar calendar = Calendar.getInstance();
              java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        
            String query = " insert into ontwerp (Beschikbaarheidspercentage, Prijs, Naam, Opslag)"
                + " values (?, ?, ?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setDouble (1, Beschikbaarheid);
            preparedStmt.setInt (2, prijs);
            preparedStmt.setString  (3, naam);
            preparedStmt.setDate(4, startDate);

      // execute the preparedstatement
            preparedStmt.execute();
            

            ResultSet myRs = myStmt.executeQuery("Select * from ontwerp");
            
            while (myRs.next()) {
                //if(myRs.getString("Naam") == naam) {
                if(myRs.getString("Naam").equals(naam)){
                ontwerpid = Integer.parseInt(myRs.getString("OntwerpID"));
                //}
                }
            }
            
            for(Server component : samenstelling) {
            String query2 = " insert into ontwerpcomponent (Ontwerpid, Component)"
                + " values (?, ?)";
            
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setInt (1, ontwerpid);
            preparedStmt2.setString (2, component.getNaam());
;
            

      // execute the preparedstatement
            preparedStmt2.execute();
            
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
    