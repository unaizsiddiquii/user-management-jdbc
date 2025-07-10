import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String pass = "your_password";
        try {
            return DriverManager.getConnection(
                   url, user, pass
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
