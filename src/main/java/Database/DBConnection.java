package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static class Student {
        private int id;
        private String firstname;
        private String lastname;
        private String email;

        public Student(int id, String firstname, String lastname, String email) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
        }

        int getId() {   return id;   }
        String getFirstname() {   return firstname;   }
        String getLastname() {   return lastname;   }
        String getEmail() { return email; }
    }

    public static class Settings {
        public static final String URL = "jdbc:mysql://localhost:3306/fahrschule";
        public static final String USER = "root";
        public static final String PASSWORD = "";
    }

    public static class Students {

        void addStudent(Student student) {
            try (Connection c = getConnection()) {
                if (c != null) {
                    PreparedStatement p2 = c.prepareStatement("INSERT INTO students(firstname, lastname, email,) VALUES (?, ?, ?)");

                    p2.setString(1, student.getFirstname());
                    p2.setString(2, student.getLastname());
                    p2.setString(3, student.getEmail());
                    p2.execute();
                    //c.commit(); //setzen, wenn AutoCommit ausgeschaltet
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        Optional<Student> getStudentById(int id) {
            try (Connection c = getConnection()) {
                PreparedStatement p = c.prepareStatement("SELECT * FROM students where id=?");
                p.setInt(1, id);
                ResultSet resultSet = p.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Student(id, resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("email")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return Optional.empty();
        }

        Optional<Student> getStudentByLastName(String lastName) {
            try (Connection c = getConnection()) {
                PreparedStatement p = c.prepareStatement("SELECT * FROM students where lastname=?");
                p.setString(1, lastName);
                ResultSet resultSet = p.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    return Optional.of(new Student(id, resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("email")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return Optional.empty();
        }


    }

    public static class Teacher {
        private int id;
        private String firstname;
        private String lastname;
        private String email;

        Teacher(int id, String firstname, String lastname, String email) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
        }
    }

    public static class Teachers {


        Optional<Teacher> getTeacherById(int id) {
            try (Connection c = getConnection()) {
                PreparedStatement p = c.prepareStatement("SELECT * FROM teachers where id=?");
                p.setInt(1, id);
                ResultSet resultSet = p.executeQuery();
                if (resultSet.next()) {
                    return Optional.of(new Teacher(id, resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("email")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return Optional.empty();
        }

        List<Student> getStudentsById(int id) {
            ArrayList<Student> students = new ArrayList<>();
            try (Connection c = getConnection()) {
                String query = """
                        SELECT students.id, students.firstname, students.lastname, students.email FROM students
                        INNER JOIN teachers ON students.teacher = teachers.id
                        """;
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                if (resultSet.next()) {
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
}
