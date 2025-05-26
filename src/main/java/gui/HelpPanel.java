package gui;

import javax.swing.*;

public class HelpPanel extends JPanel {

    HelpPanel() {
        JTextArea out = new JTextArea();

        String helpText = """
                Try the list views before the add views. The add views often need id's, which can be found in the list views.
                
                When adding a student, you need to provide the teacher id. You can find the teacher id in the list view of teachers.
                """;

        out.setText(helpText);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);

        add(out);
        setVisible(true);
    }
}
