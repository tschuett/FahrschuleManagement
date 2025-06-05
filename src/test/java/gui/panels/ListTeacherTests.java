package gui.panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTeacherTests {

    @Test
    void getBackground() {
        JScrollPane pane = new ListTeachers();
        assertEquals(Color.LIGHT_GRAY, pane.getBackground());
    }
}
