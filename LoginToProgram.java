/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project395;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Owner
 */
public class LoginToProgram {
     //FOR TESTING PURPORSES ONLY DELETE THIS AFTER MAIN CREATED and the initial connection is in main.
    private Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:‪contractDB";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established."); //Test line to see document
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    
    
 public boolean executeSearch(String usnm, String psswd) {
        String sql = "SELECT PersonID,FROM Contractor WHERE Username="+usnm+" AND Password = "+psswd;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
                
        //check if password is in database
        // return true if the combination exists else returns false
            if (rs.getInt("PersonID")==0) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    } 
    

    public String getUnameDB(){
        return "a";
    }
    
    

        //--------------------------------------------------------
    
}   

