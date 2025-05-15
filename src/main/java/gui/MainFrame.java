package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public final class MainFrame extends JFrame {
    private final Container container;
    private final JMenuItem menuItemConfig;
    private final JMenuItem menuItemHelp;
    private final JMenuItem menuItemExit;
    private final JMenuItem menuItemListStudents;
    private final JMenuItem menuItemListTeachers;
    private final JMenuItem menuItemAddStudent;
    private final JMenuItem menuItemAddTeacher;

    public MainFrame() {
        this.container = this.getContentPane();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Driving School Management");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 3));
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");


        this.menuItemConfig = new JMenuItem("Config");
        menu.add(this.menuItemConfig);
        this.menuItemListStudents = new JMenuItem("List Students");
        menu.add(this.menuItemListStudents);
        this.menuItemListTeachers = new JMenuItem("List Teachers");
        menu.add(this.menuItemListTeachers);
        this.menuItemAddStudent = new JMenuItem("Add Student");
        menu.add(this.menuItemAddStudent);
        this.menuItemAddTeacher = new JMenuItem("Add Teacher");
        menu.add(this.menuItemAddTeacher);
        this.menuItemHelp = new JMenuItem("Help");
        menu.add(this.menuItemHelp);
        this.menuItemExit = new JMenuItem("Exit");
        menu.add(this.menuItemExit);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);


        this.container.add(panel);
        this.setVisible(true);
    }

    Container getContainer() {
        return this.container;
    }

    public void addActionListenerForListStudentsMenu(ActionListener l) {
        this.menuItemListStudents.addActionListener(l);
    }

    public void addActionListenerForListTeachersMenu(ActionListener l) {
        this.menuItemListTeachers.addActionListener(l);
    }

    public void addActionListenerForAddStudentMenu(ActionListener l) {
        this.menuItemAddStudent.addActionListener(l);
    }

    public void addActionListenerForAddTeacherMenu(ActionListener l) {
        this.menuItemAddTeacher.addActionListener(l);
    }

    public void addActionListenerForHelpMenu(ActionListener l) {
        this.menuItemHelp.addActionListener(l);
    }

    public void addActionListenerForConfigMenu(ActionListener l) {
        this.menuItemConfig.addActionListener(l);
    }

    /**
     * Add an ActionListener for the exit menu
     *
     * @param l
     */
    public void addActionListenerForExitMenu(ActionListener l) {
        this.menuItemExit.addActionListener(l);
    }
}
