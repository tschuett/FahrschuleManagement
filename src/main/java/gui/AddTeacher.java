package gui;

import Database.Teachers;

import javax.swing.*;
import java.awt.*;

public class AddTeacher extends JPanel {

    AddTeacher(){
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

        JButton button = new JButton("Speichern");
        button.addActionListener(e -> {
            saveTeacher(firstName.getText(), lastName.getText(), email.getText());
        });
        add(button);
        setLayout(new GridLayout(4, 2));
    }

    private void saveTeacher(String firstName, String lastName, String email) {
        Teachers teachersDAO = new Teachers();
        teachersDAO.addTeacher(firstName, lastName, email);
    }
}
