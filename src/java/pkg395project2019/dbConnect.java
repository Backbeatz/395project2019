
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
            try {
                Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException eString) {
                    System.err.println("Could not init JDBC driver - driver not found");
}
            // db parameters
            String url = "jdbc:sqlite:D:\\MikeK\\Documents\\GitHub\\395project2019\\contractDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.err.println("Connection to SQLite has been established."); //Test line to see document
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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

