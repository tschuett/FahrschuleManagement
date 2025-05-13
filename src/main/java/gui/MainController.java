package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class MainController {
    private final MainFrame view;

    public MainController() {
        this.view = new MainFrame();
        this.view.addActionListenerForConfigMenu(this::listenConfigMenu);
        this.view.addActionListenerForListStudentsMenu(this::listenListStudentsMenu);
        this.view.addActionListenerForListTeachersMenu(this::listenListTeachersMenu);
        this.view.addActionListenerForAddStudentMenu(this::listenAddStudentMenu);
        this.view.addActionListenerForHelpMenu(this::listenHelpMenu);
        this.view.addActionListenerForExitMenu(this::listenExitMenu);
    }

    void listenConfigMenu(ActionEvent event) {
        ConfigDialog dialog = new ConfigDialog(this.view);
        dialog.setLocationRelativeTo(this.view);
        dialog.pack();
        dialog.setVisible(true);

    }

    void listenListStudentsMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        ListStudentsTableModel model = new ListStudentsTableModel();


        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        container.removeAll();
        container.add(scrollPane);
    }

    void listenListTeachersMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        ListTeachersTableModel model = new ListTeachersTableModel();

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        container.removeAll();
        container.add(scrollPane);
    }

    void listenAddStudentMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel addStudentPanel = new JPanel(new GridLayout(4, 3));
        addStudentPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        addStudentPanel.add(new JLabel("Vorname"));
        addStudentPanel.add(new JTextField());


        addStudentPanel.add(new JLabel("Geschlecht"));
        String[] genders = {"Neutral", "Männlich", "Weiblich"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        addStudentPanel.add(genderComboBox);
        JButton button = new JButton("Speichern");
        button.addActionListener(e -> {}); // FIXME
        addStudentPanel.add(button);
        container.removeAll();
        container.add(addStudentPanel);
    }

    /**
     * Listen for uses of the help menu entry. Print help text.
     *
     * @param event
     */
    void listenHelpMenu(ActionEvent event) {
        Container container = this.view.getContainer();
        JPanel helpPanel = new JPanel();
        JTextArea out = new JTextArea();

        String sb = "Enter from/to accounts" + "\n" + "Enter money amount" + "\n";

        out.setText(sb);

        helpPanel.add(out);
        container.removeAll();
        container.add(helpPanel);
    }

    /**
     * Listen for uses of the exit menu entry.
     *
     * @param event
     */
    void listenExitMenu(ActionEvent event) {
        System.exit(0);
    }
}
