package  pkg395project2019;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Arrays;
 

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
    private String currentPId;
    private String currentCId;
    
    
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
    private String job; //profession
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
    public String getcurrentPId(){
        return currentPId;
    }
    public void setcurrentPId(String ID){
        this.currentPId = ID;
    }
    public String getcurrentCId(){
        return currentPId;
    }
    public void setcurrentCId(String ID){
        this.currentPId = ID;
    }
    
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

        }
        else{
            attempts += 1;
            return "hours_reset";
        }
        query qConIn = new query();
            String hrQuery;
            Object[] infoHr = new Object[8];
            infoHr[0]=month; //Edit here
            infoHr[1]=year;
            infoHr[2]=getcurrentPId();
            infoHr[3]=getcurrentCId();
            infoHr[4]=getHours();
            
            //Need to check if month has already been used
            
            if(qConIn.insert(4, infoHr)){  //Nani?
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
    
//Not working
    public String changePass(String password, String newPassword){
        if(!(password.equals(newPassword))){

            attempts += 1;
            pass = "";
            newPass = "";
            query qUpdatePassword = new query();
            Object[] infoUpPassword = new Object[8];
            infoUpPassword[6]=newPassword;
            Object[] userInfo = new Object[8];
            userInfo[5]="test1";
            if (qUpdatePassword.update(1, infoUpPassword, userInfo)) {
                return "logged_out";
            }
            
        }
        pass = "";
        newPass = "";
        attempts = 0;
        return "change_password_reset";
        
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
    /**
     * 
     * @return webpage
     */
    public String addContractor(){
        
        //load
        String a = getFirstName();
        
        //Query
        query qConIn = new query();
        Object[] infoNC = new Object[8];
        infoNC[0]= giveNewID(1, 100); //person id
        infoNC[1]=getFirstName(); //Fname
        infoNC[2]=getLastName(); //Lname
        infoNC[3]=getPhone(); //phone
        infoNC[4]=getEmail();//email
        infoNC[5]=getCreateUser(); //uname 
        infoNC[6]=getCreatePass(); //pass
        infoNC[7]=2; //Auth Hard code as 2 for now
        // Waiting on db additions of sex and job
            
            
            if(!qConIn.insert(1, infoNC)){
                return "hours";
            } 
        return "hours";
    }
    /**
     * This generates our person ID
     * -Connor
     * @return 
     */
    public int giveNewID(int min, int max){
        //For each number in range check if in database
        for(int i=min;i<max;i++){
            query sample2 = new query();
            String testQuery2;
            Object[] testInfo2 = new Object[8];
            testInfo2[0]=i;
            testQuery2=sample2.selectWhere(1, testInfo2, testInfo2);
            if(!sample2.selectQueryFromDb()){
               return i;
           }
        }
        
        return 0;
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
        query qConIn = new query();
        Object[] testInfo2 = new Object[8];
        testInfo2[5]=username;
        testInfo2[6]=password;
        Object[] resultInfo = new Object[8];
        Arrays.fill(resultInfo, true);
        
        //This is where we're waiting for our
        String Name = qConIn.selectWhere(1, resultInfo, testInfo2);
        if (qConIn.selectQueryFromDb()) {
            resultInfo = qConIn.getResults();
            
            setcurrentPId(resultInfo[0].toString()); //this is not working
            setcurrentCId("N/A"); //need to be looked at
            
            setCurName(resultInfo[1].toString());
            setLastName(resultInfo[2].toString());
            setCurPhone(resultInfo[3].toString());
            setCurEmail(resultInfo[4].toString());
            setUsername(resultInfo[5].toString());
            
        }
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
            return "main_websi te_reset";
        }*/
