package  pkg395project2019;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bean1")
@RequestScoped
public class bean1 {

    private String hours;
    private String pass;    
    private String newPass;
    private Contractor user;
    private int attempts;
    private String username;
        
    public String getHours(){
        return hours;
    }
    public void setHours(String hours){
        this.hours = hours;
    }
    
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public void setNewPass(String newPass){
        this.newPass = newPass;
    }
    
    public String getNewPass(){
        return newPass;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    
    public class Contractor{
        public long Contractor_ID;
        public String Name;
        public String Company;
        public String Month;
        private String username;
        private String password;
    }
    
    public String verify(String hours){
        try {
            user = getContractInfo();//open up database here to input entries dependent on login.
        } catch (SQLException e) {
            //exception clause
            attempts += 1;
        }
        
        if(hours.equals("")){
            attempts += 1;
            return "hours_reset";
        }
        
        if(verifyHours(hours)){
            //Hours make sense, so parse the string to int for submission.
            int work = Integer.parseInt(hours);
            //Enter database and enter hours (work)
        }
        else{
            attempts += 1;
            return "hours_reset";
        }
        //open up the database here to submit the hours.
        /*
        try{
            
        }
        catch{SQLException e)
        */
        attempts = 0;
        return "hours_confirmed";
    }
    
    public boolean verifyHours(String hours) {
        try{
            int c_hours = Integer.parseInt(hours);
            return !((c_hours > 700) || (c_hours < 0));
	}
        catch(NumberFormatException n){
            return false;
        }
    }
    
    public String changePass(String password, String newPass){
	if(newPass.length() > 12 || newPass.length() < 6) {
		return "change_password_reset";	
	}
        try {
            user = getContractInfo();//open up database here to input entries dependent on login.
        } catch (SQLException e) {
            //exception clause
        }
	String system_pass = "a";//(from database password) 
        if(!(password.equals(system_pass))){
            attempts += 1;
            return "change_password_reset";
        }
        
        attempts = 0;
        return "logout";
    }
    
    public String checkUsername(String username){
        try{
            user = getContractInfo();
            
        } catch (SQLException e){
            //exception
        }
        //Verify if username is in system.
        //If no
       if(!(username.equals(user.username))){
            return "forgot_password_reset";
        }
        return "request_sent";
    }
   
/**
    * Searches the database for required information, mainly for display on webpage.
    * @return user (is a Contractor class item)
    * @throws java.sql.SQLException
    */
    public Contractor getContractInfo() throws SQLException{
        user = new Contractor();
        //check if source exists
        //connect to database
        //if no database throw exception
        //go through the query until matching userid is found
        //store all the data into the contractor structure
        //q = new query.main();       //connor working here
        
        //user.setContractor_ID(q);
        //user.setName(<database variable name>.getString("Name"));
        //user.setCompany(<database variable name>.getString("Company"));
        //user.setMonth(<database variable name>.getString("Month"));
        return user;
    }   
    /*Might get deprecated and simply use the <h:outputText for each line
    public String hoursDataFields(){
        String info = "";
        String name = "[Contractor Name ";
        String month = "[Reporting Period ";
      //  String id = "[Contract ID";

        if(!(user.Name.equals(""))){
            name += user.Name;
        }
        if(!(user.Month.equals(""))){
            month += user.Month; 
        }
      //  if(!(user.Contractor_ID == 0)){
            
      //  }
        
        info += name + "]\n";
        info += month + "]\n";
      //  info += id + "]\n";
        return info;
    }*/
}
