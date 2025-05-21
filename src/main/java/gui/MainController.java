package gui;

import Database.Students;
import Database.Teachers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The controller installs listeners in the view for menu items. For each menu item a method is called.
 * The methods draw visual elements in the view accordingly.
 */
public final class MainController {
    private final MainFrame view;

    public MainController() {
        this.view = new MainFrame();
        this.view.addActionListenerForConfigMenu(this::listenConfigMenu);
        this.view.addActionListenerForListStudentsMenu(this::listenListStudentsMenu);
        this.view.addActionListenerForListTeachersMenu(this::listenListTeachersMenu);
        this.view.addActionListenerForAddStudentMenu(this::listenAddStudentMenu);
        this.view.addActionListenerForAddTeacherMenu(this::listenAddTeacherMenu);
        this.view.addActionListenerForHelpMenu(this::listenHelpMenu);
        this.view.addActionListenerForExitMenu(this::listenExitMenu);
    }

    private void listenConfigMenu(ActionEvent event) {
        ConfigDialog dialog = new ConfigDialog(this.view);
        dialog.setLocationRelativeTo(this.view);
        dialog.pack();
        dialog.setVisible(true);

    }

    /**
     * Draws the list of students when the list item is clicked.
     * @param event the event of the menu click.
     */
    private void listenListStudentsMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        ListStudentsTableModel model = new ListStudentsTableModel();


        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        container.removeAll();
        container.add(scrollPane);
    }

    /**
     * Draws the list of teachers when the list item is clicked in the menu.
     * @param event the event of the menu click.
     */
    private void listenListTeachersMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        ListTeachersTableModel model = new ListTeachersTableModel();

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        container.removeAll();
        container.add(scrollPane);
    }

    private void listenAddStudentMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel addStudentPanel = new JPanel(new GridLayout(4, 2));
        addStudentPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        addStudentPanel.add(new JLabel("Vorname"));
        JTextField firstName = new JTextField();
        addStudentPanel.add(firstName);
        addStudentPanel.add(new JLabel("Nachname"));
        JTextField lastName = new JTextField();
        addStudentPanel.add(lastName);
        addStudentPanel.add(new JLabel("EMail"));
        JTextField email = new JTextField();
        addStudentPanel.add(email);
        addStudentPanel.add(new JLabel("Lehrer ID"));
        JTextField teacherId = new JTextField();
        addStudentPanel.add(teacherId);


        JButton button = new JButton("Speichern");
        button.addActionListener(e -> {
            saveStudent(firstName.getText(), lastName.getText(), email.getText(), teacherId.getText());
        });
        addStudentPanel.add(button);
        container.removeAll();
        container.add(addStudentPanel);
    }

    private void saveStudent(String firstName, String lastName, String email, String teacherId) {
        Students studentsDAO = new Students();
        studentsDAO.addStudent(firstName, lastName, email, teacherId);
    }

    private void listenAddTeacherMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel addTeacherPanel = new JPanel(new GridLayout(4, 2));
        addTeacherPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        addTeacherPanel.add(new JLabel("Vorname"));
        JTextField firstName = new JTextField();
        addTeacherPanel.add(firstName);
        addTeacherPanel.add(new JLabel("Nachname"));
        JTextField lastName = new JTextField();
        addTeacherPanel.add(lastName);
        addTeacherPanel.add(new JLabel("EMail"));
        JTextField email = new JTextField();
        addTeacherPanel.add(email);

        JButton button = new JButton("Speichern");
        button.addActionListener(e -> {
            saveTeacher(firstName.getText(), lastName.getText(), email.getText());
        });
        addTeacherPanel.add(button);

        container.removeAll();
        container.add(addTeacherPanel);
    }

    private void saveTeacher(String firstName, String lastName, String email) {
        Teachers teachersDAO = new Teachers();
        teachersDAO.addTeacher(firstName, lastName, email);
    }

    /**
     * Listen for uses of the help menu entry. Print help text.
     *
     * @param event the event when the help menu item is clicked.
     */
    private void listenHelpMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel helpPanel = new JPanel();
        JTextArea out = new JTextArea();

        String helpText = """
                Try the list views before the add views. The add views often need id's, which can be found in the list views.
                
                When adding a student, you need to provide the teacher id. You can find the teacher id in the list view of teachers.
                """;

        out.setText(helpText);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);

        helpPanel.add(out);
        helpPanel.setVisible(true);
        container.removeAll();
        container.add(helpPanel);
    }

    /**
     * Listen for uses of the exit menu entry.
     *
     * @param event
     */
    private void listenExitMenu(ActionEvent event) {
        System.exit(0);
    }
}
