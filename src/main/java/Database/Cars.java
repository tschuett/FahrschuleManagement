package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Cars {
    Optional<Car> getCarById(int id) {
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement("SELECT * FROM cars where id=?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Car(id, resultSet.getInt("driverId"), resultSet.getInt("studentId")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
