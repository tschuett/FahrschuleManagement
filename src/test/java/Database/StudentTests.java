package Database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTests {

    @Test
    void id() {
        Student student = new Student(4, "Hans", "Lauter", "lauter@gmail.com");
        assertEquals(4, student.getId());
    }

    @Test
    void at() {
        Student student = new Student(4, "Hans", "Lauter", "lauter@gmail.com");
        assertEquals("lauter@gmail.com", student.at(3));
    }

    @Test
    void email() {
        Student student = new Student(4, "Hans", "Lauter", "hans@gmail.com");
        assertEquals("hans@gmail.com", student.getEmail());
    }
}
