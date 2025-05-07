package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Teachers {

    Optional<Teacher> getTeacherById(int id) {
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement("SELECT * FROM teachers where id=?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Teacher(id, resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
