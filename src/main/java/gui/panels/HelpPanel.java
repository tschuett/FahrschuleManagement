package gui.panels;

import javax.swing.*;

public final class HelpPanel extends JPanel {

    private static final String HELP_TEXT = """
            Try the list views before the add views. The add views often need id's, which can be found in the list views.
            
            When adding a student, you need to provide the teacher id. You can find the teacher id in the list view of teachers.
            """;

    public HelpPanel() {
        JTextArea out = new JTextArea();

        out.setText(HELP_TEXT);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);

        add(out);
        setVisible(true);
    }
}
