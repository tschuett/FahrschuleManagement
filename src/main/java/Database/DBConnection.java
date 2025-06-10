package Database;

import java.sql.*;

/// A cache for MySQL connections.
final class DBConnection {
    private static Connection connection = null;


    static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(Settings.URL, Settings.USER, Settings.PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Verbindung konnte nicht hergestellt werden: " + ex.getMessage());
            }
        }
        return connection;
    }
}
