/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdygadgets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mbred
 */
public class Database {
    
    public static void main(String[] args) {    
        try{
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from infrastructuurcomponent");
            while(myRs.next()) {
                System.out.println(myRs.getString("naam"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public void test(double test) {   
        try{
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/KBS?serverTimezone=UTC","root", "");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from infrastructuurcomponent WHERE beschikbaarheidspercentage = " + test);
            while(myRs.next()) {
                System.out.println(myRs.getString("naam"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
