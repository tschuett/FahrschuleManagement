package gui;

import Database.Student;
import Database.Students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainController {
    private MainFrame view;

    public MainController() {
        this.view = new MainFrame();
        this.view.addActionListenerForListStudentsMenu(this::listenListStudentsMenu);
        this.view.addActionListenerForHelpMenu(this::listenHelpMenu);
        this.view.addActionListenerForExitMenu(this::listenExitMenu);
    }

    void listenListStudentsMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        Students students = new Students();
        List<Student> theStudents = students.listStudents();
        JPanel listPanel = new JPanel(new GridLayout(theStudents.size(), 5));

        for (Student student: theStudents) {
            // grid layout
            JLabel label = new JLabel(student.toString());
            listPanel.add(label);
        }

        container.removeAll();
        container.add(listPanel);
    }
    /**
     * Listen for uses of the help menu entry. Print help text.
     * @param event
     */
    void listenHelpMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel helpPanel = new JPanel();
        JTextArea out = new JTextArea();

        StringBuilder sb = new StringBuilder();
        sb.append("Enter from/to accounts").append("\n");
        sb.append("Enter money amount").append("\n");

        out.setText(sb.toString());

        helpPanel.add(out);
        container.removeAll();
        container.add(helpPanel);
    }

    /**
     * Listen for uses of the exit menu entry.
     * @param event
     */
    void listenExitMenu(ActionEvent event) {
        System.exit(0);
    }
}
