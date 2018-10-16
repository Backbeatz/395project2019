package project395;

/**
 *
 * @author MikeK
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addToDatabase {
        public void insertNewContractor(int PersonID, String Username, String Password, int Autherization) {
        
            String sql = "INSERT INTO Contractor(PersonID, Username, Password, Autherization) VALUES(?,?,?,?)";
            
            try (Connection conn = dbConnect.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, PersonID);
                pstmt.setString(2, Username);
                pstmt.setString(3, Password);
                pstmt.setInt(2, Autherization);
                pstmt.executeUpdate();
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
    }
    
}
