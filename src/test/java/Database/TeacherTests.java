package Database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TeacherTests {

    @Test
    void firstName() {
        Teacher teacher = new Teacher(5, "Karl", "Hummel", "karl@apple.de");
        assertEquals("Karl", teacher.getFirstName());
    }

    @Test
    void at() {
        Teacher teacher = new Teacher(7, "Heinz", "Klein", "<EMAIL>");
        assertEquals("<EMAIL>", teacher.at(3));
        assertEquals("Heinz", teacher.at(1));
        assertEquals("Klein", teacher.at(2));
        assertNotEquals("Heinz2", teacher.at(1));
        assertEquals(7, teacher.at(0));
    }
}
