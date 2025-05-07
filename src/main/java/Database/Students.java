package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Students {

    Optional<Student> getStudentById(int id) {
        try (Connection c = DBConnection.getConnection()) {
            PreparedStatement p = c.prepareStatement("SELECT * FROM students where id=?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Student(id, resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    Optional<Teacher> getTeacherForStudentById(int id) {
        try (Connection c = DBConnection.getConnection()) {
            String query = """
                    SELECT teachers.id, teachers.firstname, teachers.lastname, teachers.email
                    FROM teachers
                    INNER JOIN students ON teachers.id = student.teacher
                    WHERE student.id = ?;
                    """;
            PreparedStatement p = c.prepareStatement(query);
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

    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection c = DBConnection.getConnection()) {
            String query = "SELECT * FROM students";
            PreparedStatement p = c.prepareStatement(query);
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("firstname"),
                        resultSet.getString("lastname"), resultSet.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
