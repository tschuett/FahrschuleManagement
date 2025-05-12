package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<Teacher> listTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection c = DBConnection.getConnection()) {
            String query = "SELECT * FROM teachers";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet.getInt("id"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("email"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teachers;
    }
}
