package gui;

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
     *
     * @param event the event of the menu click.
     */
    private void listenListStudentsMenu(ActionEvent event) {
        Container container = this.view.getContainer();

        JScrollPane scrollPane = new ListStudents();

        container.removeAll();
        container.add(scrollPane);
    }

    /**
     * Draws the list of teachers when the list item is clicked in the menu.
     *
     * @param event the event of the menu click.
     */
    private void listenListTeachersMenu(ActionEvent event) {
        Container container = this.view.getContainer();

        JScrollPane listTeachers = new ListTeachers();

        container.removeAll();
        container.add(listTeachers);
    }

    private void listenAddStudentMenu(ActionEvent event) {
        Container container = this.view.getContainer();

        JPanel addStudentPanel = new AddStudent();
        container.removeAll();
        container.add(addStudentPanel);
    }

    private void listenAddTeacherMenu(ActionEvent event) {
        Container container = this.view.getContainer();

        JPanel addTeacher = new AddTeacher();
        container.removeAll();
        container.add(addTeacher);
    }

    /**
     * Listen for uses of the help menu entry. Print help text.
     *
     * @param event the event when the help menu item is clicked.
     */
    private void listenHelpMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel helpPanel = new HelpPanel();

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
