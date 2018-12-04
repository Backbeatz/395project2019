
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
            // db parameters Use Absolute Pathing name for individual PC
            //String url = "jdbc:sqlite:D:\\MikeK\\Documents\\GitHub\\395project2019\\contractDB.db";
            String url = "jdbc:sqlite:C:\\Users\\Owner\\Documents\\NetBeansProjects\\395project2019\\contractDB.db";
            //String url = "jdbc:sqlite:contractDB.db:c:/Users/Owner/Documents/NetBeansProjects/395project2019"; 
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.err.println("Connection to SQLite has been established."); //Test line to see document
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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

