
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
            String url = "jdbc:sqlite:contractDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established."); //Test line to see document
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main() {
        connect();
        
    }
}

