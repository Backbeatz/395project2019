package  pkg395project2019;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bean1")
@RequestScoped
public class bean1 {
    //Calander
    Calendar cal = Calendar.getInstance();
    //logged in user info
    private Contractor currentUser; //this is where we set our info
    private String hours;    
    
    //login page info
    private String username;
    private String pass;
    private String newPass;
    private int attempts;
    
    //info box info( name, rep period, email, phone, company )
    private String currentName;
    //Rep period is month + year
    private String currentEmail;
    private String currentPhone;
    private String currentComp;
    
    
    
    //system info
    
    //The current date and time
    Calendar now = Calendar.getInstance();
    int d1 = now.get(Calendar.YEAR);
    String year = String.valueOf(d1); //current year
    
    String month = new SimpleDateFormat("MMM").format(now.getTime()); //Current month

    //add user fields
    private Contractor newContractor;
    private String createUser;
    private String createPass;
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
    
 //---------------------------------------------------------------------------  
 // Setters and Getters
    //All
    public String getMonth(){
        return month;
    }
    
    public String getYear(){
        return year;
    }
    
    public String getHours(){
        return hours;
    }
    public void setHours(String hours){
        this.hours = hours;
    }

    //Current user
    public String getCurName(){
        return currentName;
    }
    public void setCurName(String Name){
        this.currentName = Name;
    }
    public String getCurEmail(){
        return currentEmail;
    }
    public void setCurEmail(String email){
        this.currentEmail = email;
    }
    public String getCurPhone(){
        return currentPhone;
    }
    public void setCurPhone(String phone){
        this.currentPhone = phone;
    }
    public String getCurComp(){
        return currentComp;
    }
    public void setCurComp(String company){
        this.currentComp = company;
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
    //Add user
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }
    
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
        
    //--------------------------------------------------------------------
    //Contrctor object
    public class Contractor{
        public long Contractor_ID;
        public String firstName;
        public String lastName;
        public String phoneNumber;
        public String email;
        public String Company;
        private int protocol;
    }
    
    //----------------------------------------------------------------------
    //functions
    
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
    
    public String addContractor(){
        //verify every field
        return "contractor_added";
    }
   /**
    * Sets our current user's info as the log in
    * @param username
    * @param password
    * @throws SQLException 
    */
    public void setContractInfo(String username, String password) throws SQLException{
        currentUser = new Contractor();
        //we connect to database
        
        //set our values ussing setters
        setCurName("Name");
        setCurEmail("Email");
        setCurPhone("Phone");
        setCurComp("Job");
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
