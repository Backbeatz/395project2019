/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg395project2019;

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
    

 public int executeSearch(String usnm, String psswd) {
        int AuthNum = 0; //default Autherization number 0 is error code
        String sql = "SELECT PersonID, Autherization FROM Contractor WHERE Username="+usnm+" AND Password = "+psswd;
        try (Connection conn = dbConnect.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
                
        //check if password is in database
        // return AuthorizationNUmber if the combination exists else returns false
            if (rs.getInt("PersonID")==0) {
                return AuthNum;
            }
            else {
                AuthNum = rs.getInt("Authorization");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return AuthNum;
    } 
    


    public String getUnameDB(){
        return "a";
    }
    
    


        //--------------------------------------------------------
    

}   

