//Needs SQL integration mainly and method to move to next page.

package 395project2019;

import java.sql.SQLException;

public class submitHours {
    private Contractor user;
    
    public class Contractor{
        public long Contractor_ID;
        public String Name;
        public String Company;
        public String Month;
    }
    
    public boolean submitHours(String hours){
        try {
            user = getContractInfo();//open up database here to input entries dependent on login.
        } catch (SQLException e) {
            //exception clause
        }
        
        if(hours.equals("")){
            return false; //Did not submit.
        }
        int work;
        
        if(verifyHours(hours)){
            //Hours make sense, so parse the string to int for submission.
            work = Integer.parseInt(hours);
        }
        else{
            return false;
        }
        //open up the database here to submit the hours.
        /*
        try{
            
        }
        catch{SQLException e)
        */
        return true;
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
        
        //user.setContractor_ID(<database variable name>.getlong("Contractor_ID"));
        //user.setName(<database variable name>.getString("Name"));
        //user.setCompany(<database variable name>.getString("Company"));
        //user.setMonth(<database variable name>.getString("Month"));
        return user;
    }   
    
    /**
    * override the toString method to represent the structure.
    * @return string info which contains all the fields.
    */
    @Override
    public String toString(){
        String info = "";
        info += "[Contractor Name: " + user.Name + "]\n";
        info += "[Company Name: " + user.Company + "]\n";
        info += "[Reporting Period: " + user.Month + "]\n";
        return info;
    }
}

