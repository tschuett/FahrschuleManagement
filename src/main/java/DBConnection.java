import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;


    static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(Settings.URL, Settings.USER, Settings.PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Verbindung konnte nicht hergestellt werden");
            }
        }
        return connection;
    }
}
