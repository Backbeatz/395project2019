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
    
    //Where search bar results are stored    
    private String[] SearchResultList = {"A","b"};
    
    public String[] getSearchRez(){
        return SearchResultList;
    }
    

//searchbar
    private String searchvalue;
       
    public String getAdminSearch(){
        return currentPId;
    }
    public void setAdminSearch(String searchvalue){
        this.currentPId = searchvalue;
    }
    


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
    
    private int contractID;
    private String startDate;
    private String renewalStartDate1;
    private String renewalStartDate2;
    private String endDate;
    private String renewalEndDate1;
    private String renewalEndDate2;
    private int renewalOptions;
    private float amountForContractorTerm1;
    private float amountForContractorTerm2;
    private float amountForContractorTerm3;
    private float rateForCompanyTerm1;
    private float rateForCompanyTerm2;
    private float rateForCompanyTerm3;
    
    private String compName;
    private String compCity;
    private String compAddress;
    private String compPostal;
    private String compPhone;
    private String compEmail;

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
    
    public int setcontractID(){
        return contractID;
    }
    public void setcontractID(int idNum){
        this.contractID = idNum;
    }
    public String getstartDate(){
        return startDate;
    }
    public void setstartDate(String date){
        this.startDate = date;
    }
    public String getrenewalStartDate1(){
        return renewalStartDate1;
    }
    public void setrenewalStartDate1(String date){
        this.renewalStartDate1 = date;
    }
    public String getrenewalStartDate2(){
        return renewalStartDate2;
    }
    public void setrenewalStartDate2(String date){
        this.renewalStartDate2 = date;
    }
    public String getendDate(){
        return endDate;
    }
    public void setendDate(String date){
        this.endDate = date;
    }
    public String getrenewalEndDate1(){
        return renewalEndDate1;
    }
    public void setrenewalEndDate1(String date){
        this.renewalEndDate1 = date;
    }
    public String getrenewalEndDate2(){
        return renewalEndDate2;
    }
    public void setrenewalEndDate2(String date){
        this.renewalEndDate2 = date;
    }
    public int getrenewalOptions(){
        return renewalOptions;
    }
    public void setrenewalOptions(int num){
        this.renewalOptions = num;
    }
    public float getamountForContractorTerm1(){
        return amountForContractorTerm1;
    }
    public void setamountForContractorTerm1(float amount){
        this.amountForContractorTerm1 = amount;
    }
    public float getamountForContractorTerm2(){
        return amountForContractorTerm2;
    }
    public void setamountForContractorTerm2(float amount){
        this.amountForContractorTerm2 = amount;
    }
    public float getamountForContractorTerm3(){
        return amountForContractorTerm3;
    }
    public void setamountForContractorTerm3(float amount){
        this.amountForContractorTerm3 = amount;
    }
    public float getrateForCompanyTerm1(){
        return rateForCompanyTerm1;
    }
    public void setrateForCompanyTerm1(float amount){
        this.rateForCompanyTerm1 = amount;
    }
    public float getrateForCompanyTerm2(){
        return rateForCompanyTerm2;
    }
    public void setrateForCompanyTerm2(float amount){
        this.rateForCompanyTerm2 = amount;
    }
    public float getrateForCompanyTerm3(){
        return rateForCompanyTerm3;
    }
    public void setrateForCompanyTerm3(float amount){
        this.rateForCompanyTerm3 = amount;
    }
    
    public String getcompName(){
        return compName;
    }
    public void setcompName(String name){
        this.compName = name;
    }
    public String getcompCity(){
        return compName;
    }
    public void setcompCity(String city){
        this.compName = city;
    }
    public String getcompAddress(){
        return compAddress;
    }
    public void setcompAddress(String address){
        this.compAddress = address;
    }
    public String getcompPostal(){
        return compPostal;
    }
    public void setcompPostal(String postal){
        this.compPostal = postal;
    }    
    public String getcompPhone(){
        return compPhone;
    }
    public void setcompPhone(String phone){
        this.compPhone = phone;
    }
    public String getcompEmail(){
        return compEmail;
    }
    public void setcompEmail(String email){
        this.compEmail = email;
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
    
    //-------------------Add Object Methods -----------
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
        infoNC[7]=1; //Auth Hard code as 2 for now
        // Waiting on db additions of sex and job
            
            
            if(!qConIn.insert(1, infoNC)){
                return "hours";
            } 
        return "hours";
    }
    
    public String addContract(){
        //Query
        query queryContractInsert = new query();
        Object[] insertObject = new Object[14];
        insertObject[0]= giveNewID(1, 10000); //person id        
        insertObject[1]=getstartDate(); //Fname
        insertObject[2]=getrenewalStartDate1();
        insertObject[3]=getrenewalStartDate2();
        insertObject[4]=getendDate();
        insertObject[5]=getrenewalEndDate1();
        insertObject[6]=getrenewalEndDate2();
        insertObject[7]=getrenewalOptions();
        insertObject[8]=getamountForContractorTerm1();
        insertObject[9]=getamountForContractorTerm2();
        insertObject[10]=getamountForContractorTerm3();
        insertObject[11]=getrateForCompanyTerm1();
        insertObject[12]=getrateForCompanyTerm2();
        insertObject[13]=getrateForCompanyTerm3();       
        if(!queryContractInsert.insert(3, insertObject)){
                return  "adminMain";
            } 
        return "adminMain";
    }
    public String addCompany(){
        //Query
        query queryCompanyInsert = new query();
        Object[] insertObject = new Object[7];
        insertObject[0]= giveNewID(1, 10000); //person id        
        insertObject[1]=getcompName(); //Fname
        insertObject[2]=getcompCity();
        insertObject[3]=getcompAddress();
        insertObject[4]=getcompPostal();
        insertObject[5]=getcompPhone();
        insertObject[6]=getcompEmail();
             
        if(!queryCompanyInsert.insert(2, insertObject)){
                return "adminMain";
            } 
        return "adminMain";
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
    
    //--------------------------------------
    
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
        Object[][] resultInfo = new Object[1][8];
        Arrays.fill(resultInfo[0], true);
        
        //This is where we're waiting for our
        String Name = qConIn.selectWhere(1, resultInfo[0], testInfo2);
        if (qConIn.selectQueryFromDb()) {
            resultInfo = qConIn.getResults();
            
            setcurrentPId(resultInfo[0][0].toString()); //this is not working
            setcurrentCId("N/A"); //need to be looked at
            
            setCurName(resultInfo[0][1].toString());
            setLastName(resultInfo[0][2].toString());
            setCurPhone(resultInfo[0][3].toString());
            setCurEmail(resultInfo[0][4].toString());
            setUsername(resultInfo[0][5].toString());
            
        }
    }
    
    
    
    /**
     * Connor's search results NEEDS TO BE UPDATED
     * @param SearchCrit
     * @param SearchVal
     * @return 
     */
    public String ConductSearch(String SearchCrit, String SearchVal){
        //check in db for fields 
        //SearchCrit is field, SearchVal is what we search for
        //use selectwhere?
        //display results
        
        //If you want to find all compagnies where the compagny_name contains USA just do :
        //SELECT * FROM Company
        //WHERE company_name like '%USA%';

        System.out.print("Here is where it starts");
        //Set up query
        query searchQuery = new query();
        Object[] testInfo2 = new Object[8];
        Object[] resultInfo = new Object[8];
        
        if("FName".equals(SearchCrit)){
           testInfo2[2]=SearchVal;

        }
        if("LName".equals(SearchCrit)){
            testInfo2[3]=SearchVal;
            
        }
        if("Email".equals(SearchCrit)){
            testInfo2[4]=SearchVal;
        }
        if("Phone".equals(SearchCrit)){
            testInfo2[5]=SearchVal;
        }
        if("company".equals(SearchCrit)){
            testInfo2[6]=SearchVal;
        }
        if("UName".equals(SearchCrit)){
           testInfo2[7]=SearchVal;
            
        }
        Arrays.fill(resultInfo, true);
        String queryz = searchQuery.selectWhere(1, resultInfo, testInfo2);
        System.out.println("----------------------------" + queryz);
        if (searchQuery.selectQueryFromDb()){ //change this
            resultInfo = searchQuery.getResults(); 
            System.out.println("+++++++++" +resultInfo.toString());
        }
        
        return "adminSearchResults";
        
        }
    
    

   public String login(String username, String password) throws SQLException{
        //Needs to be changed to compare to database, just dummy login
        query sample2 = new query();
        String testQuery2;
        Object[] testInfo2 = new Object[8];
        testInfo2[5]=username;
        testInfo2[6]=password;
        
        Object[] fieldsToGet = new Object[8];
        fieldsToGet[5] = true;
        fieldsToGet[6] = true;
        fieldsToGet[7] = true;
        
        testQuery2=sample2.selectWhere(1, fieldsToGet, testInfo2);
        
        //testQuery2=sample2.selectWhere(1, testInfo2, testInfo2);
        
        boolean a = sample2.selectQueryFromDb();
        Object[][] result = new Object[1][8];
        result = sample2.getResults();
        if(a == true){
           setContractInfo(username, password);
           System.err.println(result[0][7].toString());
           if (result[0][7].toString().compareTo("1")==0) { //for Contractor
            return "hours";
           }
           if (result[0][7].toString().compareTo("2")==0) { //for Admin
            return "adminMain"; //<--- Change to Admin page
           }
           return "login";
        }
        else {
            return "login";
        }
   }
}
