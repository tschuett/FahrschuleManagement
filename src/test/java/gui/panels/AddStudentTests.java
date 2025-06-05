package gui.panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AddStudentTests {

    @Test
    void addStudentLayout() {
        JPanel panel = new AddStudent();
        assertInstanceOf(GridLayout.class, panel.getLayout());
    }

    @Test
    void addStudentPanelCount() {
        JPanel panel = new AddStudent();
        assertEquals(9, panel.getComponentCount());
    }

    @Test
    void firstIsLabel() {
        JPanel panel = new AddStudent();
        assertInstanceOf(JLabel.class, panel.getComponent(2));
    }
}
