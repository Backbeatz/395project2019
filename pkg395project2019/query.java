/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;

/**
 *
 * @author MikeK
 */
public class query {
    public Boolean insert (String table, Object[] info) {
        table.toLowerCase();
        return true;
    }  
    //INSERT INTO Contractor(PersonID, Username, Password, Authorization) VALUES(?,?,?,?)"1
    
    /*public String select () {
    
    }*/
    public static void main(String args[])
    {
        query obj = new query();
        //obj.disp('a');
        //obj.disp(5);
    }
}

/*CREATE TABLE Contractor (
    PersonID int NOT NULL PRIMARY KEY,
    FirstName varchar(255),
    LastName varchar(255),
    PhoneNumber varchar(255),
    Email varchar(255),
    Username varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    Autherization int
    );
*/