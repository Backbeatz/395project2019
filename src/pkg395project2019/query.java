/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MikeK
 */
public class query {
    private StringBuilder queryString = new StringBuilder();
    String[] contractorTable = new String[8];
    String[] companyTable = new String[7];
    String[] contractTable = new String[14];
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
        companyTable[5]="PhoneNumber";
        companyTable[6]="Email";
        
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
    
        timeTable[0]="Month";
        timeTable[1]="Year";
        timeTable[2]="ContractID";
        timeTable[3]="PersonID";
        timeTable[4]="TimeEntry";
    }
    
    /**
     *
     * @param tableIdentifier identifier for table use 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
     * @param info variables which you are inserting  position is based on table see query constructor
     *INSERT INTO Contractor(PersonID, Username, Password, Authorization) VALUES(?,?,?,?)"   
     * @return
     */
    public String insert (int tableIdentifier, Object[] info) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        int size;
        String table;
        this.queryString.append("INSERT INTO ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=7;
                break;
            case 2:
                table = "Company";
                size=6;
                break;
            case 3:
                table = "Contract";
                size=13;
                break;
            case 4:
                table = "TimeClock";
                size=4;
                break;
            default:
                return "NULL";
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
                queryString.append(info[x]);
                queryString.append(", "); //dont thiink this works correctly
            }
            x++;
        }
        
        this.queryString.deleteCharAt(queryString.length()-1);
        this.queryString.deleteCharAt(queryString.length()-1);
        queryString.append(")");
        
        return queryString.toString();
    }  
    
    /**
     *
     *@param tableIdentifier identifier for table use 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
     * @param info variables which you are inserting  position is based on table see query constructor
     * @return String to be used in sql query
     *SELECT (COLUMN NAMES) From Table"   
     * NEEDS TO ADD THE WHERE condition
     * @return 
     */
    public String select (int tableIdentifier, Object[] info) {
        //table identifier should be 1 for Contractor, 2 for company, 3 for contract, 4 for timeclock
        //Creates the correct table and start of the query
        int size;
        String table;
        this.queryString.append("SELECT ");
        switch (tableIdentifier) {
            case 1:
                table = "Contractor";
                size=7;
                break;
            case 2:
                table = "Company";
                size=6;
                break;
            case 3:
                table = "Contract";
                size=13;
                break;
            case 4:
                table = "TimeClock";
                size=4;
                break;
            default:
                return "NULL";
        }
        
        //Adds the column names to the string 
        queryString.append(" (");
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
        queryString.append("FROM ");
        queryString.append(table);
        
        return queryString.toString();
    }  
    
    public void insertQuery() {
        if (this.queryString!=null) {
            try (Connection conn = dbConnect.connect();
                PreparedStatement pstmt = conn.prepareStatement(this.queryString.toString())) {                
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());        }
        }
    }
    
    public static void main(String args[])
    {
        query obj = new query();

    }
}
