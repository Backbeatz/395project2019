
package pkg395project2019;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class dbConnect {
     /**
     * Connect to a sample database
     * @return 
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:contractDB.db:c:/Users/Owner/Documents/NetBeansProjects/395project2019"; //need albsloute pathname
            // create a connection to the database
            System.out.println(url + " url !!!!!");
            conn = DriverManager.getConnection(url);
            System.out.println(conn + " conn zzzz");
                    
            
            
            
        } catch (SQLException e) {
            System.out.print("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        }
        return conn; //returns null currently
    }
    /**
     * @param args the command line arguments
     */
    public static void main() {
        connect();
        
    }
}

