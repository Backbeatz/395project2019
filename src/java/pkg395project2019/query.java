/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MikeK
 */

public class query {
    private StringBuilder queryString = new StringBuilder();
    int tableIdentifier;
    int numOfResults;
    
    ResultSet savedSet;
    Object[][] contractorResultInfo = new Object[100][8];
    Object[][] companyResultInfo = new Object[100][7];
    Object[][] contractResultInfo = new Object[100][16];
    Object[][] timeTableResultInfo = new Object[100][5];
    
    String[] contractorTable = new String[9];
    String[] companyTable = new String[8];
    String[] contractTable = new String[16];
    String[] timeTable = new String[5];
    
    public query() {
        contractorTable[0]="PersonID";
        contractorTable[1]="FirstName";
        contractorTable[2]="LastName";
        contractorTable[3]="PhoneNumber";
        contractorTable[4]="Email";
        contractorTable[5]="Username";
        contractorTable[6]="Password";
        contractorTable[7]="Authorization";
        
        companyTable[0]="CompanyID";
        companyTable[1]="CompanyName";
        companyTable[2]="City";
        companyTable[3]="StreetAddress";
        companyTable[4]="PostalCode";
        companyTable[5]="Province";
        companyTable[6]="PhoneNumber";
        companyTable[7]="Email";
        
        contractTable[0]="ContractID";
        contractTable[1]="StartDate";
        contractTable[2]="RenewalStartDate1";
        contractTable[3]="RenewalStartDate2";
        contractTable[4]="EndDate";
        contractTable[5]="RenewalEndDate1";
        contractTable[6]="RenewalEndDate2";
        contractTable[7]="RenewalOptions";
        contractTable[8]="AmountForContractorTerm1";
        contractTable[9]="AmountForContractorTerm2";
        contractTable[10]="AmountForContractorTerm3";
        contractTable[11]="RateForCompanyTerm1";
        contractTable[12]="RateForCompanyTerm2";
        contractTable[13]="RateForCompanyTerm3";
        contractTable[14]="PersonID";
        contractTable[15]="CompanyID";
    
        timeTable[0]="Month";
        timeTable[1]="Year";
        timeTable[2]="ContractID";
        timeTable[3]="ContractorID";
        timeTable[4]="TimeEntry";
        
        tableIdentifier = 0;
        numOfResults = 0;
    }
    
    /**
     *
     * @param tableIdentifier identifier for table use 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
     * @param info variables which you are inserting  position is based on table see query constructor
     *INSERT INTO Contractor(PersonID, Username, Password, Authorization) VALUES(?,?,?,?)"   
     * @return
     */
    public boolean insert (int whichTable, Object[] info) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        this.tableIdentifier = whichTable;
        int size;
        String table;
        this.queryString.append("INSERT INTO ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=8;
                break;
            case 2:
                table = "Company";
                size=8;
                break;
            case 3:
                table = "Contract";
                size=16;
                break;
            case 4:
                table = "TimeClock";
                size=5;
                break;
            default:
                return false;
        }
        this.queryString.append(table);
        
        //Adds the column names to the string 
        this.queryString.append(" (");
        
        int x = 0;
        
        while (x<size) {    
            if (info[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        this.queryString.append(contractorTable[x]);
                        break;
                    case 2:
                        this.queryString.append(companyTable[x]);
                        break;
                    case 3:
                        this.queryString.append(contractTable[x]);
                        break;
                    case 4:
                        this.queryString.append(timeTable[x]);
                        break;
                    default:
                        break;
                }
                this.queryString.append(", "); //dont thiink this works correctly
            }
            x++;
        }
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        
        this.queryString.append(") VALUES(");
        
        //Adds the value names to the string 
        x = 0;
        while (x<size) {    
            if (info[x]!=null) {
                if (info[x] instanceof String) {
                    queryString.append("\""); 
                }
                queryString.append(info[x]);
                if (info[x] instanceof String) {
                    queryString.append("\""); 
                }
                queryString.append(", "); 
            }
            x++;
        }
        
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        queryString.append(")");
        
        boolean success = false;
        System.err.println(queryString.toString());
        success = insertQueryToDb();
        
        if (success) {
            System.out.println("The insert was Successful");
        }
        return success;
    }  
    
    /**
     *
     * @param whichTable table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
     * @param updateInfo the information to update
     * @param itemWhere the information to match in database
     * @return
     */
    public boolean update (int whichTable, Object[] updateInfo, Object[] itemWhere) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        this.tableIdentifier = whichTable;
        int size;
        String table;
        this.queryString.append("UPDATE ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=8;
                break;
            case 2:
                table = "Company";
                size=8;
                break;
            case 3:
                table = "Contract";
                size=16;

                break;
            case 4:
                table = "TimeClock";
                size=5;
                break;
            default:
                return false;
        }
        this.queryString.append(table);
        int x = 0;
        //Adds the column names to the string 
        this.queryString.append(" SET ");
        x = 0;
        
        while (x<size) {    
            if (updateInfo[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        queryString.append(contractorTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(updateInfo[x]);
                        queryString.append("\'");
                        break;
                    case 2:
                        queryString.append(companyTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(updateInfo[x]);
                        queryString.append("\'");
                        break;
                    case 3:
                        queryString.append(contractTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(updateInfo[x]);
                        queryString.append("\'");
                        break;
                    case 4:
                        queryString.append(timeTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(updateInfo[x]);
                        queryString.append("\'");
                        break;
                    default:
                        break;
                }
                queryString.append(" , "); //dont thiink this works correctly
                
            }
            x++;
        }
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);        
        queryString.append(" WHERE ");
        
        x = 0;
        while (x<size) {
            System.err.println("WOOHOO!");
            if (itemWhere[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        queryString.append(contractorTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        //if (info[x] instanceof String) {
                            //queryString.append("\""); 
                        //}
                        queryString.append(itemWhere[x]);
                        queryString.append("\'");
                        //if (info[x] instanceof String) {
                            //queryString.append("\""); 
                        //}
                        break;
                    case 2:
                        queryString.append(companyTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(itemWhere[x]);
                        queryString.append("\'");
                        break;
                    case 3:
                        queryString.append(contractTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(itemWhere[x]);
                        queryString.append("\'");
                        break;
                    case 4:
                        queryString.append(timeTable[x]);
                        queryString.append("=");
                        queryString.append("\'");
                        queryString.append(itemWhere[x]);
                        queryString.append("\'");
                        break;
                    default:
                        break;
                }
                queryString.append(" AND "); //dont thiink this works correctly
                
            }
            x++;
        }
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        
        System.err.println(queryString.toString());
        //Adds the value names to the string 
        x = 0;
        queryString.append(";");
        
        boolean success = false;
        success = insertQueryToDb();
        
        if (success) {
            System.out.println("The insert was Successful");
        }
        return success;
    }  
    
    /**
     *
     *@param whichTable identifier for table use 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
     * @param info variables which you are inserting  position is based on table see query constructor
     * @return String to be used in sql query
     *SELECT (COLUMN NAMES) From Table"   
     * NEEDS TO ADD THE WHERE condition
     * @return 
     */
    public String select (int whichTable, Object[] info) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        this.tableIdentifier = whichTable;
        int size;
        String table;
        this.queryString.append("SELECT ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=8;
                break;
            case 2:
                table = "Company";
                size=8;
                break;
            case 3:
                table = "Contract";
                size=16;
                break;
            case 4:
                table = "TimeClock";
                size=5;
                break;
            default:
                return "NULL";
        }
        
        //Adds the column names to the string 
        int x = 0;
        while (x<size) {    
            if (info[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        queryString.append(contractorTable[x]);
                        break;
                    case 2:
                        queryString.append(companyTable[x]);
                        break;
                    case 3:
                        queryString.append(contractTable[x]);
                        break;
                    case 4:
                        queryString.append(timeTable[x]);
                        break;
                    default:
                        break;
                }
                queryString.append(", "); //dont thiink this works correctly
                
            }
            x++;
        }
        
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        queryString.append(" FROM ");
        queryString.append(table);
        
        return queryString.toString();
    }  
    
    /**
     *
     * @param whichTable Table to query
     * @param info Object outlining which information is wanted
     * @param item Object with items for comparison 
     * @return
     */
    public String selectWhere (int whichTable, Object[] info, Object[] item) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        this.tableIdentifier = whichTable;
        int size;
        String table;
        this.queryString.append("SELECT ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=8;
                break;
            case 2:
                table = "Company";
                size=8;
                break;
            case 3:
                table = "Contract";
                size=16;
                break;
            case 4:
                table = "TimeClock";
                size=5;
                break;
            default:
                return "NULL";
        }
        
        //Adds the column names to the string 
        int x = 0;
        while (x<size) {    
            if (info[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        queryString.append(contractorTable[x]);
                        break;
                    case 2:
                        queryString.append(companyTable[x]);
                        break;
                    case 3:
                        queryString.append(contractTable[x]);
                        break;
                    case 4:
                        queryString.append(timeTable[x]);
                        break;
                    default:
                        break;
                }
                queryString.append(", "); //dont thiink this works correctly
            }
            x++;
        }
        
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        queryString.append(" FROM ");
        queryString.append(table);
        queryString.append(" WHERE ");
        
        x = 0;
        
        while (x<size) {    
            if (item[x]!=null) {
                switch (tableIdentifier) {
                    case 1:
                        queryString.append(contractorTable[x]);
                        queryString.append("=");
                        queryString.append("\"");
                        //if (info[x] instanceof String) {
                            //queryString.append("\""); 
                        //}
                        queryString.append(item[x]);
                        queryString.append("\"");
                        //if (info[x] instanceof String) {
                            //queryString.append("\""); 
                        //}
                        break;
                    case 2:
                        queryString.append(companyTable[x]);
                        queryString.append("=");
                        queryString.append("\"");
                        queryString.append(item[x]);
                        queryString.append("\"");
                        break;
                    case 3:
                        queryString.append(contractTable[x]);
                        queryString.append("=");
                        queryString.append("\"");
                        queryString.append(item[x]);
                        queryString.append("\"");
                        break;
                    case 4:
                        queryString.append(timeTable[x]);
                        queryString.append("=");
                        queryString.append("\"");
                        queryString.append(item[x]);
                        queryString.append("\"");
                        break;
                    default:
                        break;
                }
                queryString.append(" AND "); //dont thiink this works correctly
                
            }
            x++;
        }
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        
        System.err.println(queryString.toString());
        return queryString.toString();
        
    }  
    
    /**
     *Code modified from source: http://www.sqlitetutorial.net/sqlite-java/insert/
     */
    private boolean insertQueryToDb() {
        if (this.queryString!=null) {
            try ( Connection conn = dbConnect.connect();  
                    PreparedStatement pstmt = conn.prepareStatement(this.queryString.toString())) {  
                pstmt.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }
    
    /**
     *Code modified from source: http://www.sqlitetutorial.net/sqlite-java/select/
     * @return returns Boolean for successful or not
     */
    
    public boolean selectQueryFromDb(){
        
        Connection conn = dbConnect.connect();
        if (conn == null) {
            return false;
        }
        int indexForResultSet = 0;
        try  (Statement stmt  = conn.createStatement();
             ResultSet rs = stmt.executeQuery(this.queryString.toString())){
            
            // loop through the result set 
            boolean empty = true;
            ResultSetMetaData rsmd = rs.getMetaData();
            numOfResults = 0; //counts how many rows of results were populated
            int columnNum = 1; // counts how many columns were returned
            String columnName = "";
            while( rs.next() ) {
                while (columnNum <= rsmd.getColumnCount()) {
                    columnName = rsmd.getColumnName(columnNum);
                    
                // ResultSet processing here
                    switch (tableIdentifier) {
                    case 1:
                        for (int x=0; x<=7; x++) { //needed to get which index to add to
                            if (contractorTable[x].compareTo(columnName)==0) {
                                contractorResultInfo[numOfResults][x]=rs.getString(columnName);
                            }
                        }
                        break;
                    case 2:
                        for (int x=0; x<=7; x++) { //needed to get which index to add to
                            if (companyTable[x].compareTo(columnName)==0) {
                                companyResultInfo[numOfResults][x]=rs.getString(columnName);
                            }
                        }
                        break;
                    case 3:
                        for (int x=0; x<=15; x++) { //needed to get which index to add to
                            if (contractTable[x].compareTo(columnName)==0) {
                                contractResultInfo[numOfResults][x]=rs.getString(columnName);
                            }
                        }
                        break;
                    case 4:
                        for (int x=0; x<=4; x++) { //needed to get which index to add to
                            if (timeTable[x].compareTo(columnName)==0) {
                                timeTableResultInfo[numOfResults][x]=rs.getString(columnName);
                            }
                        }
                        break;
                    default: ;
                    }
                columnNum++;
                }
                columnNum = 1;
            numOfResults++;
            
            empty = false;
            }

            if( empty ) {
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
        if (conn != null) {
        try {
            conn.close();
            } catch (SQLException e) { /* ignored */}
        }
        //System.err.println("----------Print of Result Table------------");
        //printItemsinResultTables();
        try {
            conn.close();
            } catch (SQLException e) {
        }
        
        return true;
    }
    
    public Object[][] getResults() {
        switch (tableIdentifier) {
                    case 1:
                        return contractorResultInfo;                
                    case 2:
                        return companyResultInfo;
                    case 3:
                        return contractResultInfo;
                    case 4:
                        return timeTableResultInfo;
                    default:
                        break;
                }
        return null;
    }
    
    public void printItemsinResultTables() {
        int index = 0;
        int x = 0;
        while (x<this.numOfResults) {
            index=0;
            System.err.println("contractor Result Info:\n");
            while (index<8) {    
                if (contractorResultInfo[index]!=null) {
                     System.err.println(contractorResultInfo[x][index]+"\n");
                }
                index++;
            }
            index=0;
            System.err.println("company Result Info:\n");
            while (index<8) {    
                if (companyResultInfo[index]!=null) {
                    System.err.println(companyResultInfo[x][index]+"\n");
                }
                index++;
            }
            index=0;
            System.err.println("Contract Result Info:\n");
            while (index<15) {    
                if (contractResultInfo[index]!=null) {
                    System.err.println(contractResultInfo[x][index]+"\n");
                }
                index++;
            }
            index=0;
            System.err.println("timeTable Result Info:\n");
            while (index<5) {    
                if (timeTableResultInfo[index]!=null) {
                    System.err.println(timeTableResultInfo[x][index]+"\n");
                }
                index++;
            }
            x++;
        }
        System.err.println("-----End of Result Table-----");
        return;
    }
    
    public static void main(String args[])
    {

    }
}