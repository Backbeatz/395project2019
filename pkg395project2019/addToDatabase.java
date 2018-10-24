package pkg395project2019;

/**
 *
 * @author MikeK
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addToDatabase {
        public void insertNewContractor(int PersonID, String Username, String Password, int Authorization) {
        
            String sql = "INSERT INTO Contractor(PersonID, Username, Password, Authorization) VALUES(?,?,?,?)";
            
            try (Connection conn = dbConnect.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, PersonID);
                pstmt.setString(2, Username);
                pstmt.setString(3, Password);
                pstmt.setInt(4, Authorization);
                pstmt.executeUpdate();
                System.out.println("Success!"); //Test Line Please Delete after confirmation
                
            } catch (SQLException e) {
                System.out.println("Failure!"); //Test Line Please Delete after confirmation
                System.out.println(e.getMessage());        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        addToDatabase test = new addToDatabase();
        test.insertNewContractor(2,"Mike2","Password2",1);
        
    }
}
