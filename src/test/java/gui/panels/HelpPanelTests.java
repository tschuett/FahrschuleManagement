package gui.panels;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class HelpPanelTests {

    private static final String HELP_TEXT = """
            Try the list views before the add views. The add views often need id's, which can be found in the list views.
            
            When adding a student, you need to provide the teacher id. You can find the teacher id in the list view of teachers.
            """;

    @Test
    void checkForTextArea() {
        JPanel help = new HelpPanel();
        assertInstanceOf(JTextArea.class, help.getComponent(0));
    }

    @Test
    void testTextArea() {
        JPanel help = new HelpPanel();
        Component text = help.getComponent(0);
        if (text instanceof JTextArea area) {
            assertEquals(HELP_TEXT, area.getText());
        }
    }
}
