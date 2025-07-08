import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb", "root", "US0726unaiz@"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
