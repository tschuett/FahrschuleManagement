package gui.panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ListStudentTests {

    @Test
    void checkBackground() {
        JScrollPane pane = new ListStudents();
        assertEquals(Color.DARK_GRAY, pane.getBackground());
    }

    @Test
    void checkView() {
        JScrollPane pane = new ListStudents();
        assertInstanceOf(JTable.class, pane.getViewport().getView());
    }
}
