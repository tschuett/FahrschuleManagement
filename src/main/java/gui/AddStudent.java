package gui;

import Database.Students;

import javax.swing.*;
import java.awt.*;

public class AddStudent extends JPanel {

    AddStudent() {
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(new JLabel("Vorname"));
        JTextField firstName = new JTextField();
        add(firstName);
        add(new JLabel("Nachname"));
        JTextField lastName = new JTextField();
        add(lastName);
        add(new JLabel("EMail"));
        JTextField email = new JTextField();
        add(email);
        add(new JLabel("Lehrer ID"));
        JTextField teacherId = new JTextField();
        add(teacherId);


        JButton button = new JButton("Speichern");
        button.addActionListener(e -> {
            saveStudent(firstName.getText(), lastName.getText(), email.getText(), teacherId.getText());
        });
        add(button);
        setLayout(new GridLayout(4, 2));
    }

    private void saveStudent(String firstName, String lastName, String email, String teacherId) {
        Students studentsDAO = new Students();
        studentsDAO.addStudent(firstName, lastName, email, teacherId);
    }
}
