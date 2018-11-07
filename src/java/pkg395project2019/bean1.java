package  pkg395project2019;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bean1")
@RequestScoped
public class bean1 {
    //user
    private String hours;    
    private String newPass;
    private Contractor user; //this
    private Contractor newContractor; //this
    private int attempts;
    private String username;
    private String pass;
    //for add contractor
    private String firstName;
    private String lastName;
    private String job;
    private String city;
    private String province;
    private String postalCode;
    private String email;
    private String phone;
    private String dob; //Date of Birth
    private String sex;
    private String createUser;
    private String createPass;
    
    public String getDob(){
        return dob;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    
    public String getCreateUser(){
        return createUser;
    }
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }
    
    public String getCreatePass(){
        return createPass;
    }
    public void setCreatePass(String createPass){
        this.createPass = createPass;
    }
    
    public String getProvince(){
        return province;
    }
    public void setProvince(String province){
        this.province = province;
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
        
    public String getHours(){
        return hours;
    }
    public void setHours(String hours){
        this.hours = hours;
    }
    
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }
    
    public String getPass(){
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }

    public String getNewPass(){
        return newPass;
    }
    public void setNewPass(String newPass){
        this.newPass = newPass;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    
    public class Contractor{ //this
        public long Contractor_ID;
        public String firstName;
        public String lastName;
        public String phoneNumber;
        public String email;
        public String Company;
        public String Month;
        public String Year;
        public String activeContract;
        private int protocol;
    }
    
    public String verify(String hours){
        if(hours.equals("")){
            attempts += 1;
            return "hours_reset";
        }
        
        if(verifyInt(hours)){
            
            //Hours make sense, so parse the string to int for submission.
            int work = Integer.parseInt(hours);
            if((work > 700) || (work < 0)){
                return "hours_reset";
            }
            //hour
            query Worktime = new query();
            String testQuery;
            Object[] newCont = new Object[5];
            newCont[0]= user.Month; //month
            newCont[1]= user.Year; //year
            newCont[2]= user.activeContract; //ContractID
            newCont[3]= user.Contractor_ID; //PersonID
            newCont[4]= hours; //Timeentry
            boolean a = Worktime.insert(4, newCont);
            
            
            //insert hour into entry 
            //Enter database and enter hours (work)
        }
        else{
            attempts += 1;
            return "hours_reset";
        }
        attempts = 0;
        return "hours_confirmed";
    }
    
    public boolean verifyInt(String num) {
        try{
            int c_hours = Integer.parseInt(num);
            return true;
	}
        catch(NumberFormatException n){
            return false;
        }
    }
    

    public String changePass(String password, String newPassword){
        if(!(password.equals(newPassword))){

            attempts += 1;
            pass = "";
            newPass = "";
            return "change_password_reset";
        }
        pass = "";
        newPass = "";
        attempts = 0;
        return "logged_out";
        
    }
    /*For forgot_password page 
    public String checkUsername(String username){
        
        try{
            //open database, if found send a message to the user (method unsure).
            return "request_sent";
        } catch (SQLException e){
            //exception
            return "forgot_password_reset";
        }
        
    }*/
    //Connor working
    public String addContractor(){
        //verify every field
        //take user
        
        //take
        
        
        return "contractor_added";

    }
   
    public void setContractInfo(String username, String password) throws SQLException{
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
        
        
        
    }   

   public String login(String username, String password) throws SQLException{
        //Needs to be changed to compare to database, just dummy login
        query sample2 = new query();
        String testQuery2;
        Object[] testInfo2 = new Object[8];
        testInfo2[5]=username;
        testInfo2[6]=password;
        testQuery2=sample2.selectWhere(1, testInfo2, testInfo2);
        
        boolean a = sample2.selectQueryFromDb();
        if(a == true){
           setContractInfo(username, password);
           return "hours"; 
        }
        else {
            return "login";
        }
   }
}

        //Open database and look for a similar login (if found, compare pass)
      /*  try{
            user = getContractInfo(username, password);//Open database here
            attempts = 0;
            switch (user.protocol) {
                case 0:
                    //Contractor access, sent to hours page.
                    return "hours";
                case 1:
                    //Admin access, no admin only pages as of yet.
                    return "hours";
                case 2:
                    //Super admin access, no super-admin only pages yet
                    return "hours";
                default:
                    //Issue with database entries, so simply reset.
                    return "main_website_reset";
            }
        } catch (SQLException e){
            //Exception clause
            attempts += 1;
            return "main_website_reset";
        }*/