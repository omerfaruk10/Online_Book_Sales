package online_book_sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 * @author Omer Faruk
 */
public class DbHelper {
    private String userName = "root";
    private String password = "1234";
    private String dbUrl = "jdbc:mysql://localhost:3306/kitap";
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
    
    public void executeUpdate(String sql, int siparisID) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, siparisID);

            stmt.executeUpdate();
        }
    }
}
