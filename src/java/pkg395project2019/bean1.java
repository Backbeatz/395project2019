package  pkg395project2019;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
 

@ManagedBean(name="bean1")
@SessionScoped
public class bean1 {
    //System
    //--------------------------------------------------------------------
    Calendar cal = Calendar.getInstance();
    private String hours;//The amount of hours inputed    
    Calendar now = Calendar.getInstance(); //Calander our system uses
    int d1 = now.get(Calendar.YEAR); 
    String year = String.valueOf(d1); //current year
    String month = new SimpleDateFormat("MMM").format(now.getTime()); //Current month
    private emailSystem emSystem = new emailSystem();
    
    //Invoice
    //--------------------------------------------------------------------
    private String ourCompany = "ThisCompany"; // The current company that's using the system
    private String ourAddress = "621b Bakerstreet";
    private String targetCompany; //Company we're invoicing
    private String invoiceMonth;
    private String invoiceYear;
    private int invoiceNum = 0;
    private String targetAddress;
    private float totalDue;
    private float totalPaid = 0;
    private float ballancePay;
    
    //Current user
    //-------------------------------------------------------------------
    private String newPass; 
    private String username;
    private String pass;
    private int attempts;
    private String currentFName;
    private String currentLName;
    //Rep period is month + year
    private String currentEmail;
    private String currentPhone;
    private String currentComp;
    private int currentPId;
    private int currentCId;
    private boolean currentAuth = false;

    //Admin Create users/contractor
    //--------------------------------------------------------------------
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
    private String contractorID;
    //Admin Create company record
    //--------------------------------------------------------------------
    private String compName;
    private String compID;
    private String compCity;
    private String compAddress;
    private String compPostal;
    private String compPhone;
    private String compEmail;
    //Admin Contract 
    //--------------------------------------------------------------------
    private String contractID; //int
    private String startDate;
    private String renewalStartDate1;
    private String renewalStartDate2;
    private String endDate;
    private String renewalEndDate1;
    private String renewalEndDate2;
    private int renewalOptions; //int
    private float amountForContractorTerm1; //float
    private float amountForContractorTerm2; //float
    private float amountForContractorTerm3; //float
    private float rateForCompanyTerm1; //float
    private float rateForCompanyTerm2; //float
    private float rateForCompanyTerm3; //float
    //Admin search 
    //--------------------------------------------------------------------
    private int listedrowItem; //number of rows in result
    private String[] SearchResultString; //String of search results
    private Object[][] SearchResultList; //Where search bar results to be shown are stored 
    private String searchCrit; //String that holds search type
    private String searchvalue; //String that holds search term
//String that holds search term
    //check flags
    //--------------------------------------------------------------------

    private boolean isPID;
    //flag for checking if company ID exists
    //flag for checking if Contractor ID exists
    private boolean isCID; 
    
    //email
    //--------------------------------------------------------------------
    private String messageText;
    private String messageTitle;
    private String receptients; //change to array for multiple
    //Getters and setters
    //----------------------------------------------------------------------
    
    
    public String getOurCompany(){
        return ourCompany;
    }
    public void setOurCompany(String txt){
        this.ourCompany = txt;
    }
    public String getOurAddress(){
        return ourAddress;
    }
    public void setOurAddress(String txt){
        this.ourAddress = txt;
    }
    
    public float getBallancePay(){
        return ballancePay;
    }
    public void setBallancePay(float txt){
        this.ballancePay = txt;
    }        
    public float getTotalDue(){
        return totalDue;
    }
    public void setTotalDue(float txt){
        this.totalDue = txt;
    }
    public float getTotalPaid(){
        return totalPaid;
    }
    public void setTotalPaid(float txt){
        this.totalPaid = txt;
    }
    public String getTargetAddress(){
        return targetAddress;
    }
    public void setTargetAddress(String txt){
        this.targetAddress = txt;
    }
    
    
    /**
     * Gets our email message's text
     * @return 
     */
    public String getMessageText(){
        return messageText;
    }
    /**
     * Set our email message's text
     * @param txt 
     */
    public void setMessageText(String txt){
        this.messageText = txt;
    }
    /**
     * Gets our email's subject line
     * @return 
     */
    public String getMessageTitle(){
        return messageTitle;
    }
    /**
     * Sets our email's subject line
     * @param txt 
     */
    public void setMessageTitle(String txt){
        this.messageTitle = txt;
    }
    /**
     * Gets who we are emailing
     * @return 
     */
    public String getReceptients(){
        return receptients;
    }
    /**
     * Set's our email's
     * @param target 
     */
    public void setReceptients(String target){
        this.receptients = target;
    }
    /**
     * Gives current user's personal ID
     * @return 
     */
    public int getcurrentPId(){
        return currentPId;
    }
    /**
     * Sets current user's personal ID
     * @param ID
     */
    public void setcurrentPId(int ID){
        this.currentPId = ID;
    }
    /**
     * Gets the current user's contract's id
     * @return
     */
    public int getcurrentCId(){
        return currentCId;
    }
    /**
     * Sets current user's contract's id
     * @param ID
     */
    public void setcurrentCId(int ID){
        this.currentCId = ID;
    }
    /**
     * Get the current month
     * @return
     */
    public String getMonth(){
        return month;
    }
    /**
     * Get current year
     * @return 
     */
    public String getYear(){
        return year;
    }
    /**
     * Get inputted hours
     * @return 
     */
    public String getHours(){
        return hours;
    }
    /**
     * Set the inputed hours
     * @param hours 
     */
    public void setHours(String hours){
        this.hours = hours;
    }
    /**
     * Get current user's first name
     * @return 
     */
    public String getCurFirstName(){
        return currentFName;
    }
    /**
     * Set current user's first name field
     * @param Name 
     */
    public void setCurFirstName(String Name){
        this.currentFName = Name;
    }
    /**
     * Get current user's last name
     * @return 
     */
    public String getCurLastName(){
        return currentLName;
    }
    /**
     * Set current users last name
     * @param lastName 
     */
    public void setCurLastName(String lastName){
        this.currentLName = lastName;
    }
    /**
     * Get current user's email
     * @return 
     */
    public String getCurEmail(){
        return currentEmail;
    }
    /**
     * Set current email
     * @param email 
     */
    public void setCurEmail(String email){
        this.currentEmail = email;
    }
    /**
     * Get current user's phone number
     * @return 
     */
    public String getCurPhone(){
        return currentPhone;
    }
    /**
     * Set current user's phone 
     * @param phone 
     */
    public void setCurPhone(String phone){
        this.currentPhone = phone;
    }
    /**
     * Get current company the user's working for
     * @return 
     */
    public String getCurComp(){
        return currentComp;
    }
    /**
     * Set current user's company
     * @param company 
     */
    public void setCurComp(String company){
        this.currentComp = company;
    } 
    /**
     * Get current user's password
     * @return 
     */
    public String getPass(){
        return pass;
    }
    /**
     * Set current user's password
     * @param pass 
     */
    public void setPass(String pass){
        this.pass = pass;
    }
    /**
     * Get current user's new password
     * @return 
     */
    public String getNewPass(){
        return newPass;
    }
    /**
     * Set current user's new password
     * @param newPass 
     */
    public void setNewPass(String newPass){
        this.newPass = newPass;
    } 
    /**
     * Get current user's username
     * @return 
     */
    public String getUsername(){
        return username;
    }
    /**
     * Set current user's username
     * @param username 
     */
    public void setUsername(String username){
        this.username = username;
    }
    /**
     * Get new user's home city
     * @return
     */
    public String getCity(){
        return city;
    }
    /**
     * Set new user's home city
     * @param city
     */
    public void setCity(String city){
        this.city = city;
    }
    /**
     * Get new user's username
     * @return
     */
    public String getCreateUser(){
        return createUser;
    }
    /**
     * Set new user's username
     * @param createUser
     */
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }    
    /**
     * Get new user's password
     * @return
     */
    public String getCreatePass(){
        return createPass;
    }
    /**
     * Set new user's password
     * @param createPass
     */
    public void setCreatePass(String createPass){
        this.createPass = createPass;
    }    

    /**
     * Get new user's province
     * @return
     */
    public String getProvince(){
        return province;
    }
    /**
     * Set new user's province
     * @param province 
     */
    public void setProvince(String province){
        this.province = province;
    }
    /**
     * Get new user postal code
     * @return 
     */
    public String getPostalCode(){
        return postalCode;
    }
    /**
     * Set postal code for new user
     * @param postalCode 
     */
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    /**
     * Get newly created user's email
     * @return 
     */
    public String getEmail(){
        return email;
    }
    /**
     * Sets newly created user's email
     * @param email 
     */
    public void setEmail(String email){
        this.email = email;
    } 
    /**
     * Gets newly created user's phone number
     * @return 
     */
    public String getPhone(){
        return phone;
    }
    /**
     * Sets newly created user's phone number
     * @param phone 
     */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /**
     * Get newly created user's first name
     * @return 
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * Set newly created user's First Name
     * @param firstName 
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    } 
    /**
     * Get newly created user's last name
     * @return 
     */
    public String getLastName(){
        return lastName;
    }
    /**
     *  Set newly created user's last name
     * @param lastName 
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    /**
     * Get the contractor ID
     * @return
     */
    public String getContractorID(){
        return contractID;
    }
    /**
     * Set the contractor ID
     * @param idNum
     */
    public void setContractorID(String idNum){
        this.contractID = idNum;
    }
    /**
     *
     * @return
     */
    public String getContractID(){
        return contractID;
    }
    /**
     *
     * @param idNum
     */

    public void setContractID(String idNum){
        this.contractID = idNum;
    }
    /**
     * Get start date on contract
     * @return 
     */
    public String getStartDate(){
        return startDate;
    }
    /**
     * Set start date on contract
     * @param date
     */
    public void setStartDate(String date){
        this.startDate = date;
    }
    /**
     * Get renewal 1 start date on contract
     * @return
     */
    public String getRenewalStartDate1(){
        return renewalStartDate1;
    }
    /**
     * Set renewal 1 start date on contract
     * @param date
     */
    public void setRenewalStartDate1(String date){
        this.renewalStartDate1 = date;
    }
    /**
     * Get renewal 2 start date on contract
     * @return
     */
    public String getRenewalStartDate2(){
        return renewalStartDate2;
    }
    /**
     * Set renewal 2 start date on contract
     * @param date
     */
    public void setRenewalStartDate2(String date){
        this.renewalStartDate2 = date;
    }
    /**
     * Get Contract end date
     * @return
     */
    public String getEndDate(){
        return endDate;
    }
    /**
     * Set Contract end date
     * @param date
     */
    public void setEndDate(String date){
        this.endDate = date;
    }
    /**
     * Get renewal 1 end date on contract
     * @return
     */
    public String getRenewalEndDate1(){
        return renewalEndDate1;
    }
    /**
     * Set renewal 1 end date on contract
     * @param date
     */
    public void setRenewalEndDate1(String date){
        this.renewalEndDate1 = date;
    }
    /**
     * Get renewal 2 end date on contract
     * @return
     */
    public String getRenewalEndDate2(){
        return renewalEndDate2;
    }
    /**
     * Set renewal 2 end date on contract
     * @param date
     */
    public void setRenewalEndDate2(String date){
        this.renewalEndDate2 = date;
    }
    /**
     * Get renewal options on contract
     * @return
     */
    public int getRenewalOptions(){
        return renewalOptions;
    }
    /**
     * Set renewal options on contract
     * @param num
     */
    public void setRenewalOptions(int num){
        this.renewalOptions = num;
    }
    /**
     * Get the term 1 amount
     * @return
     */
    public float getAmountForContractorTerm1(){
        return amountForContractorTerm1;
    }
    /**
     * Set the term 1 amount
     * @param amount
     */
    public void setAmountForContractorTerm1(float amount){
        this.amountForContractorTerm1 = amount;
    }
    /**
     * Get the term 2 amount
     * @return
     */
    public float getAmountForContractorTerm2(){
        return amountForContractorTerm2;
    }
    /**
     * Set the term 2 amount
     * @param amount
     */
    public void setAmountForContractorTerm2(float amount){
        this.amountForContractorTerm2 = amount;
    }
    /**
     * Get the term 3 amount
     * @return
     */
    public float getAmountForContractorTerm3(){
        return amountForContractorTerm3;
    }
    /**
     * Set the term 3 amount
     * @param amount
     */
    public void setAmountForContractorTerm3(float amount){
        this.amountForContractorTerm3 = amount;
    }
    /**
     * Get the term 1 rate
     * @return
     */
    public float getRateForCompanyTerm1(){
        return rateForCompanyTerm1;
    }
    /**
     * Set the term 1 rate
     * @param amount
     */
    public void setRateForCompanyTerm1(float amount){
        this.rateForCompanyTerm1 = amount;
    }
    /**
     * Get the term 2 rate
     * @return
     */
    public float getRateForCompanyTerm2(){
        return rateForCompanyTerm2;
    }
    /**
     * Set the term 2 rate
     * @param amount
     */
    public void setRateForCompanyTerm2(float amount){
        this.rateForCompanyTerm2 = amount;
    }
    /**
     * Get the term 3 rate
     * @return
     */
    public float getRateForCompanyTerm3(){
        return rateForCompanyTerm3;
    }
    /**
     * Set the term 3 rate
     * @param amount
     */
    public void setRateForCompanyTerm3(float amount){
        this.rateForCompanyTerm3 = amount;
    }
    /**
     * Gets the company's ID
     * @return
     */
    public String getCompID(){
        return compName;
    }
    /**
     * Sets the company's name
     * @param id
     */
    public void setCompID(String id){
        this.compName = id;
    }
    /**
     * Gets the company's name
     * @return
     */
    public String getCompName(){
        return compName;
    }
    /**
     * Sets the company's name
     * @param name
     */
    public void setCompName(String name){
        this.compName = name;
    }
    /**
     * Gets the company's city of origin
     * @return 
     */
    public String getCompCity(){
        return compName;
    }
    /**
     * Sets the company's city of origin
     * @param city 
     */
    public void setCompCity(String city){
        this.compName = city;
    }
    /**
     * Gets the company's street address
     * @return 
     */
    public String getCompAddress(){
        return compAddress;
    }
    /**
     * Sets the company's street address
     * @param address 
     */
    public void setCompAddress(String address){
        this.compAddress = address;
    }
    /**
     * Gets company postal code
     * @return 
     */
    public String getCompPostal(){
        return compPostal;
    }
    /**
     * Sets company's postal code
     * @param postal 
     */
    public void setCompPostal(String postal){
        this.compPostal = postal;
    }
    /**
     * Get the company's phone number
     * @return 
     */
    public String getCompPhone(){
        return compPhone;
    }
    /**
     * Set company phone number
     * @param phone 
     */
    public void setCompPhone(String phone){
        this.compPhone = phone;
    }
    /**
     * Gets company email
     * @return 
     */
    public String getCompEmail(){
        return compEmail;
    }
    /**
     * Sets company's email
     * @param email 
     */
    public void setCompEmail(String email){
        this.compEmail = email;
    }    
    /**
     * Gets our search term
     * @return 
     */
    public String getAdminSearch(){
        return searchvalue;
    }
    /**
     * Sets our search term
     * @param searchvalue 
     */
    public void setAdminSearch(String searchvalue){
        this.searchvalue = searchvalue;
    }
    /**
     * Gets our search criteria
     * @return 
     */
    public String getSearchCrit(){
        return searchCrit;
    }
    /**
     * Sets the search criteria
     * @param crit 
     */
    public void setSearchCrit(String crit){
        this.searchCrit = crit;
    }
    /**
     * Gets search bar results as an object
     * @return 
     */
    public Object[][] getSearchRez(){
        return SearchResultList;
    }
    /**
     * Sets search bar results as object
     * @param rez 
     */
    public void setSearchRez(Object[][] rez){
        this.SearchResultList = rez;
    }
    /**
     * Getter for row number in search results
     * @return 
     */
    public int getListedrowItem(){
        return listedrowItem;
    }
    /**
     * Setter for row in search results
     * @param crit 
     */
    public void setListedrowItem(int crit){
        this.listedrowItem = crit;
    }
    /**
     * Gives a string array of results
     * @return 
     */
    public String[] getSearchRezSt(){
        return SearchResultString;
    }
    /**
     * Sets our string array of results
     * @param rez 
     */
    public void setSearchRezSt(String[] rez){
        this.SearchResultString = rez;
    }
    public boolean getIsCID(){
        return isCID;
    }
    public void setIsCID(boolean isIt){
        this.isCID = isIt;
    }
    public boolean getIsPID(){
        return isPID;
    }
    public void setIsPID(boolean isIt){
        this.isPID = isIt;
    }
    
    public String getTargetCompany(){
        return targetCompany;
    }
    public void setTargetCompany(String isIt){
        this.targetCompany = isIt;
    }
    
    public String getInvoiceMonth(){
        return invoiceMonth;
    }
    public void setInvoiceMonth(String isIt){
        this.invoiceMonth = isIt;
    }
    public String getInvoiceYear(){
        return invoiceYear;
    }
    public void setInvoiceYear(String isIt){
        this.invoiceYear = isIt;
    }        
   
    //___________________Setting the Hours_____________________________
	
    /**
     * Verifies if the number of hours is correct
     * @param hours is a String to be tested if it falls in range of 0-700hours
     * @return webpage
     */
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
        getContractInfo();
        query qConIn = new query();
            String hrQuery;
            Object[] infoHr = new Object[8];
            infoHr[0]=month; //Edit here
            infoHr[1]=year;
            infoHr[2]=currentCId;
            infoHr[3]=currentPId;
            infoHr[4]=getHours();
            
            //Need to check if month has already been used
            
            if(qConIn.insert(4, infoHr)){  //Nani?
                return "hours_reset";
            } 

        attempts = 0;
        return "hours_confirmed";
    }
    /**
     * Simple way to verify if a number in a string is an integer
     * @param num is a String to be tested
     * @return boolean
     */
    public boolean verifyInt(String num) {
        try{
            int c_hours = Integer.parseInt(num);
            return true;
	}
        catch(NumberFormatException n){
            return false;
        }
    }
    private void getContractInfo (){
     //Now get contract
        query qConIn = new query();
        Object[] testInfo2 = new Object[16];
        testInfo2[14]=getcurrentPId();
        Object[][] resultInfo = new Object[1][16];
        Arrays.fill(resultInfo[0], true);
        String Name = qConIn.selectWhere(3, resultInfo[0], testInfo2);
        if (qConIn.selectQueryFromDb()) {
            resultInfo = qConIn.getResults();
            try {
                setcurrentCId(Integer.parseInt(resultInfo[0][0].toString()));
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
            /*
            setcontractID(Integer.parseInt(resultInfo[0][0].toString()));
            setstartDate(resultInfo[0][1].toString());
            setrenewalStartDate1(resultInfo[0][2].toString());
            setrenewalStartDate2(resultInfo[0][3].toString());
            setendDate(resultInfo[0][4].toString());
            setrenewalEndDate1(resultInfo[0][5].toString());
            setrenewalEndDate2(resultInfo[0][6].toString());
            setrenewalOptions(Integer.parseInt(resultInfo[0][7].toString()));
            setamountForContractorTerm1(Float.parseFloat(resultInfo[0][8].toString()));
            setamountForContractorTerm2(Float.parseFloat(resultInfo[0][9].toString()));
            setamountForContractorTerm3(Float.parseFloat(resultInfo[0][10].toString()));
            setrateForCompanyTerm1(Float.parseFloat(resultInfo[0][11].toString()));
            setrateForCompanyTerm2(Float.parseFloat(resultInfo[0][12].toString()));
            setrateForCompanyTerm3(Float.parseFloat(resultInfo[0][13].toString()));
            */
    }
    
    /*--------------------Changing Password-----------------------------*/
    /**
     * This changes the password of a user
     * @param password the old password required from the user to be replaced
     * @param newPassword the new password required from the user to replace the.
     * @return 
     */
    public String changePass(String password, String newPassword){
    	if(newPassword.trim().length() > 0){
        	if(password.trim().length() > 0){
            	if(!(password.equals(newPassword))){

                	attempts += 1;
                	pass = "";
                	newPass = "";
                	query qUpdatePassword = new query();
                	Object[] infoUpPassword = new Object[8];
                	infoUpPassword[6]=newPassword;
                	Object[] userInfo = new Object[8];
                	userInfo[5]=getUsername();
                	if (qUpdatePassword.update(1, infoUpPassword, userInfo)) {
                    	return "logged_out";
                	}
            	}
        	}
    	}
    	return "adminMain";
    }
    //-------------------Add Object Methods -----------
    
    public String emailUsers(String to, String msg1, String msg2){       
        if(emSystem.sendUMsg(receptients, msg1, msg2)){
            return "adminMain";
        }
        return "emailTestPage";
    }
    
    /**Adds a contractor into the system through user input from an admin.
     * 
     * @return webpage
     */
    public String addContractor(){
        if(getFirstName().trim().equals("")){
            return "adminMain";
        }
        if(getLastName().trim().equals("")){
            return "adminMain";
        }
        if(getEmail().trim().equals("")){
            return "adminMain";
        }
        if(getCreateUser().trim().equals("")){
            return "adminMain";
        }
        if(getCreatePass().trim().equals("")){
            return "adminMain";
        }
        //load
        String a = getFirstName();
        
        //Query
        query qConIn = new query();
        Object[] infoNC = new Object[8];
        infoNC[0]= giveNewID(1, 100000); //person id
        infoNC[1]=getFirstName(); //Fname
        infoNC[2]=getLastName(); //Lname
        infoNC[3]=getPhone(); //phone
        infoNC[4]=getEmail();//email
        infoNC[5]=getCreateUser(); //uname 
        infoNC[6]=getCreatePass(); //pass
        infoNC[7]=1; //Auth Hard code as 2 for now
            
        if(!qConIn.insert(1, infoNC)){
            return "adminMain";
        } 
        return "adminMain";
    }
    /**
     * This updates the contractor based on the admin's edits on adminUserEdit page
     * @return webpage
     */
    public String updateContractor(){
        query qUpdateFields = new query();
        Object[] infoUpFields = new Object[8];
        infoUpFields[1]=getFirstName();
        infoUpFields[2]=getLastName();
        infoUpFields[3]=getPhone();
        infoUpFields[4]=getEmail();
        infoUpFields[5]=getCreateUser();
        infoUpFields[6]=getCreatePass();
        Object[] userInfo = new Object[8];
        userInfo[0]=getcurrentPId();
        if (qUpdateFields.update(1, infoUpFields, userInfo)) {
            return "adminMain";
        }     
        return "adminUserEdit";
    }
    
    /**
     * This gets the fields necessary for the admin to see the current values
     * before the edit them.
     * @param text is the string of information about the user.
     * @return webpage
     */
    public String editContractor(String text){
        String pID = text.substring(1, 2);
        if(verifyInt(pID)){
            int personID = Integer.parseInt(pID);
            
            query qConIn = new query();
            Object[] testInfo2 = new Object[8];
            testInfo2[0]=personID;
            Object[][] resultInfo = new Object[1][8];
            Arrays.fill(resultInfo[0], true);
            String Name = qConIn.selectWhere(1, resultInfo[0], testInfo2);
            if (qConIn.selectQueryFromDb()) {
                resultInfo = qConIn.getResults();
                //sets our main fields for editing
                setcurrentPId(Integer.parseInt(resultInfo[0][0].toString())); 
                setFirstName(resultInfo[0][1].toString());
                setLastName(resultInfo[0][2].toString());
                setPhone(resultInfo[0][3].toString());
                setEmail(resultInfo[0][4].toString());
                setCreateUser(resultInfo[0][5].toString()); 
                setCreatePass(resultInfo[0][6].toString());
                return "adminUserEdit";
               }
        }
        return "adminSearchResults";
    }
    
    /**
     * This adds a contract into the database based on user input given.
     * @return webpage
     */
    public String addContract(){
        //Query
        boolean flag = true;
        query queryContractInsert = new query();
        Object[] insertObject = new Object[16];
        insertObject[0]= getContractID();
        insertObject[1]=getStartDate(); //Fname
        insertObject[2]=getRenewalStartDate1();
        insertObject[3]=getRenewalStartDate2();
        insertObject[4]=getEndDate();
        insertObject[5]=getRenewalEndDate1();
        insertObject[6]=getRenewalEndDate2();
        insertObject[7]=getRenewalOptions();
        insertObject[8]=getAmountForContractorTerm1();
        insertObject[9]=getAmountForContractorTerm2();
        insertObject[10]=getAmountForContractorTerm3();
        insertObject[11]=getRateForCompanyTerm1();
        insertObject[12]=getRateForCompanyTerm2();
        insertObject[13]=getRateForCompanyTerm3();
        
        query checkCompany = new query();
        Object[] checkObject = new Object[8];
        checkObject[0]=getContractorID();
        Object[] fieldsToGet = new Object[8];
        fieldsToGet[0]=true;
        checkCompany.selectWhere(1, fieldsToGet, checkObject);
        if (checkCompany.selectQueryFromDb()) {
            insertObject[14]=getContractorID();
        }
        else {
            setIsPID(false);
            flag = false;
        }
        
        checkCompany = new query();
        checkObject = new Object[8];
        checkObject[0]=getCompID();
        fieldsToGet = new Object[8];
        fieldsToGet[0]=true;
        checkCompany.selectWhere(2, fieldsToGet, checkObject);
        if (checkCompany.selectQueryFromDb()) {
            insertObject[16]=getCompID();
        }
        else {
            setIsCID(false);
            flag = false;
        }
        

        if(!queryContractInsert.insert(3, insertObject)){
                return  "adminMain";
                
            } 
        return "adminMain";
    }
    /**
     * This adds the company to the database based on variables given through
     * user input.
     * @return webpage
     */
    public String addCompany(){
        //Query
        query queryCompanyInsert = new query();
        Object[] insertObject = new Object[7];
        insertObject[0]= giveNewID(1, 10000); //person id        
        insertObject[1]=getCompName(); //Fname
        insertObject[2]=getCompCity();
        insertObject[3]=getCompAddress();
        insertObject[4]=getCompPostal();
        insertObject[5]=getCompPhone();
        insertObject[6]=getCompEmail();
             
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
    private void setUserInfo(String username, String password) throws SQLException{
        
        //we get the User information
        query qConIn = new query();
        Object[] testInfo2 = new Object[8];
        testInfo2[5]=username;
        testInfo2[6]=password;
        Object[][] resultInfo = new Object[1][8];
        Arrays.fill(resultInfo[0], true);
        String Name = qConIn.selectWhere(1, resultInfo[0], testInfo2);
        if (qConIn.selectQueryFromDb()) {
            resultInfo = qConIn.getResults();
            //sets our main feilds for User
            setcurrentPId(Integer.parseInt(resultInfo[0][0].toString())); 
            setCurFirstName(resultInfo[0][1].toString());
            setCurLastName(resultInfo[0][2].toString());
            setCurPhone(resultInfo[0][3].toString());
            setCurEmail(resultInfo[0][4].toString());
            setUsername(resultInfo[0][5].toString()); 
        } 
    }
    /**
     * Dependedent on level sends you back to your main
     * @return 
     */
    public String changePassBack(){
        if(currentAuth == true){
          return "adminMain";  
        }
        return "hours";
    }
    
    /**
     * Connor's search results 
     * @param SearchCrit
     * @param SearchVal
     * @return 
     */
    public String ConductSearch(String SearchCrit, String SearchVal){
        
        
        //Find number of rows
        query qConIn1 = new query();
        Object[] testInfo1 = new Object[8];
        //Selection of areas
        
        if("FName".equals(SearchCrit)){
            testInfo1[1]=SearchVal;
            }
        if("LName".equals(SearchCrit)){
            testInfo1[2]=SearchVal;
        }
        if("Email".equals(SearchCrit)){
            testInfo1[3]=SearchVal;
        }
        if("Phone".equals(SearchCrit)){
            testInfo1[4]=SearchVal;
        }
        if("UName".equals(SearchCrit)){    
            testInfo1[5]=SearchVal;
        }
        
        Object[][] resultInfo1 = new Object[1][8];
        Arrays.fill(resultInfo1[0], true);
        String Name1 = qConIn1.selectWhere(1, resultInfo1[0], testInfo1);
        if (qConIn1.selectQueryFromDb()) { //this
            //qConIn.numOfResults;?
            int rezCol = qConIn1.numOfResults;
            //find number
            query qConIn2 = new query();
            Object[] testInfo2 = new Object[8];
            //Selection of areas

            if("FName".equals(SearchCrit)){
                testInfo2[1]=SearchVal;
                }
            if("LName".equals(SearchCrit)){
                testInfo2[2]=SearchVal;
            }
            if("Email".equals(SearchCrit)){
                testInfo2[3]=SearchVal;
            }
            if("Phone".equals(SearchCrit)){
                testInfo2[4]=SearchVal;
            }
            if("UName".equals(SearchCrit)){    
                testInfo2[5]=SearchVal;
            }
              //This is where problem is
            
            Object[][] resultInfo2 = new Object[rezCol][8];
            Arrays.fill(resultInfo2[0], true);
            String Name2 = qConIn2.selectWhere(1, resultInfo2[0], testInfo2); 
            
            if (qConIn2.selectQueryFromDb()) {  //This is where trouble for multiple is.
            //qConIn.numOfResults;?
                //qConIn2.printItemsinResultTables();
                resultInfo2 = qConIn2.getResults();
                SearchResultList = resultInfo2;
                String[] SearchResultString = GiveStringResults(resultInfo2, rezCol);
                listedrowItem = SearchResultString.length;
                return "adminSearchResults";
            }
            return "adminMain";
            
        }
        return "adminMain";
    }
    /**
     * Function for turning our results object in to a set of strings.
     * For the search results page.
     * @param res
     * @return 
     */
    public static String[] GiveStringResults (Object[][] res, int num){
        int i= 0;
        int x = 0;
        int j =0;
        String newline = "";
        String[] stringArray = new String[num];
        while (x<num) {
            i=0;
            newline = "";
            while (i<8) {    
                if (res[i]!=null) {
                    
                    newline = newline + res[x][i].toString();
                }
                i++;
            }
            stringArray[x] = newline;
            x++;  
        }
              // while (j<num) {
              //System.out.print(stringArray[j]);
              //j++;
              //}
        return stringArray;
        
    }
    
    

    /**
     * Tells us if string is in our array, helper function 
     * @param array
     * @param item
     * @return 
     */
    public static boolean contains(String[] array, String item) {
        for (String n : array) {
            if (item.equals(n)) {
                return true;
            }
        }
      return false;
    }
    /**
     * Generate invoice values
     * @param toWho
     * @param month
     * @param year
     * @return 
     */
    public String Invoice(String toWho, String month, String year ){
        int x = 0;
        int y = 0;
        float totalCharge = 0;
        //Find company id from company table
        query qConIn = new query();
        Object[] testInfo = new Object[7];
        testInfo[1]=toWho;
        Object[][] compInfo = new Object[1][7];
        Arrays.fill(compInfo[0], true);
        String Name = qConIn.selectWhere(2, compInfo[0], testInfo);
        if (qConIn.selectQueryFromDb()) {  
                compInfo = qConIn.getResults(); //result from company table
                String compIDz = compInfo[0][0].toString(); //Company ID
                targetAddress = compInfo[0][3].toString() + "," + compInfo[0][2].toString() + "Box:" + compInfo[0][4].toString();
                //Find the amount of contracts from this company
                query qConIn1 = new query();
                Object[] testInfo1 = new Object[16];
                testInfo1[15]=compIDz;//here
                Object[][] contInfo1 = new Object[1][16];
                Arrays.fill(contInfo1[0], true);
                String Name1 = qConIn1.selectWhere(3, contInfo1[0], testInfo1);
                if (qConIn1.selectQueryFromDb()) {  
                    
                    int numofresol = qConIn1.numOfResults;//number of contracts company has
                    System.out.print(numofresol + "number of results" );
                    //get contracts from company
                    query qConIn2 = new query();
                    Object[] testInfo2 = new Object[16];
                    testInfo2[15]=compIDz; //here
                    Object[][] contInfo2 = new Object[numofresol][16];
                    Arrays.fill(contInfo2[0], true);
                    String Name2 = qConIn2.selectWhere(3, contInfo2[0], testInfo2);
                    if (qConIn2.selectQueryFromDb()) {
                        contInfo2 = qConIn2.getResults(); //result from our contract table (2d array) 
                        //This would be used in invoice page to display the contracts and the charges.
                        while (x<numofresol) { //cycle thru contracts
                            String getRate = contInfo2[x][8].toString();
                            float ourRate = Float.parseFloat(getRate); //Currently only takes the rate of orginal contract time. 
                            //Other times and rates will be implimented at later updates
                            //We have our rate now need hours
                            String thePID = contInfo2[x][14].toString();
                            String theCtID = contInfo2[x][0].toString();
                            //Find amount of timeclock
                            query qConIn3 = new query();
                            Object[] testInfo3 = new Object[5];
                            testInfo3[1]=month;
                            testInfo3[1]=year;
                            testInfo3[2]=theCtID;
                            testInfo3[3]=thePID;
                            Object[][] resultInfo3 = new Object[1][5];
                            Arrays.fill(resultInfo3[0], true);
                            String Name3 = qConIn3.selectWhere(4, resultInfo3[0], testInfo3);
                            if (qConIn3.selectQueryFromDb()) {
                                int numofterms = qConIn3.numOfResults;
                                query qConIn4 = new query();
                                Object[] testInfo4 = new Object[5];
                                testInfo4[0]=month;
                                testInfo4[1]=year;
                                testInfo4[2]=theCtID;
                                testInfo4[3]=thePID;
                                Object[][] resultInfo4 = new Object[numofterms][5];
                                Arrays.fill(resultInfo4[0], true);
                                String Name4 = qConIn4.selectWhere(4, resultInfo4[0], testInfo4);
                                if (qConIn4.selectQueryFromDb()) {
                                    resultInfo4 = qConIn4.getResults(); // now we have times
                                    String holderz;
                                    float zhrz;
                                    while (y < numofterms){
                                        holderz = resultInfo4[y][4].toString();
                                        zhrz = Float.parseFloat(holderz);
                                        totalCharge += (zhrz * ourRate );
                                        System.out.print(totalCharge);
                                        y++;
                                    }
                                }
                            }
                            x++;
                        }
                    }  
                    
                }
        }
        ballancePay = totalCharge - totalPaid;
        totalDue = totalCharge;
        
        return "display_invoice";   
    }

   /**
    * Log into system
    * @param username
    * @param password
    * @return
    * @throws SQLException 
    */
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
           setUserInfo(username, password);
           if (result[0][7].toString().compareTo("1")==0) { //for Contractor
            currentAuth = false;
            return "hours";
           }
           if (result[0][7].toString().compareTo("2")==0) { //for Admin
            currentAuth = true;
            return "adminMain"; //<--- Change to Admin page
           }
           return "login_reset";
        }
        else {
            return "login_reset";
        }
   }
   /**
    * Nulls the system's fields and transfers us to log in screen
    * @return 
    */
    public String logoff(){
        hours = null;
        newPass = null; 
        username = null;
        pass = null;
        attempts = 0;
        currentFName = null;
        currentLName = null;
        currentEmail = null;
        currentPhone = null;
        currentComp = null;
        currentPId = 0;
        currentCId = 0;
        currentAuth = false;

        createUser = null;
        createPass = null;
        firstName = null;
        lastName = null;
        job = null; 
        city = null;
        province = null;
        postalCode = null;
        email = null;
        phone = null;
        

        compName = null;
        compCity = null;
        compAddress = null;
        compPostal = null;
        compPhone = null;
        compEmail = null;

        contractID = "0";
        startDate = null;
        renewalStartDate1 = null;
        renewalStartDate2 = null;
        endDate = null;
        renewalEndDate1 = null;
        renewalEndDate2 = null;
        renewalOptions = 0;
        amountForContractorTerm1 = 0;
        amountForContractorTerm2 = 0;
        amountForContractorTerm3 = 0;
        rateForCompanyTerm1 = 0;
        rateForCompanyTerm2 = 0;
        rateForCompanyTerm3 = 0;

        listedrowItem = 0;
        SearchResultString = null; 
        SearchResultList = null; 
        searchCrit = null; 
        searchvalue = null; 
        
        ourCompany = null; 
        targetCompany = null; 
        
        
        return "login";  
   }
}
