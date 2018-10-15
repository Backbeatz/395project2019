/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 395project2019;

/**
 *
 * @author Owner
 */
public class LoginToProgram {
 public boolean loginToProgram(String usnm, String psswd) {
        String uName;
        String pWord;
        uName = usnm;
        pWord = psswd;

        //check if username is in database
        if(checkUsnm(uName)){
            if(checkpsswd(uName,pWord)){
            return true;    
            }
            
        }
        //check if password is in database
        // return true if both cases pass
        
        
        return false;
    } 
    
    /**
     * check's our username against database
     * @param usnm
     * @return true if username in database
     */
    public boolean checkUsnm(String usnm){
        String name;
        name = usnm;
        //check database for username
        //needs to be changed for db acess
        return false;
    }
   /**
     * check's our password against username's password
     * @param usnm 
     * @param psswrd 
     * @return true if we are on right username and psswrd in database
     */
    public boolean checkpsswd(String usnm,String psswrd){
        String name;
        name = usnm;
        String pass;
        pass = psswrd;
        //check database for username
        if(name == usnm){ //needs to be changed for db acess
            //check that entry for password
            if(pass == psswrd){ //needs to be changed for db access
               return true; 
            }
        }
        
        
        return false;
    }
    /**
     * Get's the usename
     * @return string rep of username 
     */
    public String getUnameDB(){
        return "a";
    }
    
    
}   

