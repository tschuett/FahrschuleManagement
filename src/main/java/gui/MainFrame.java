package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Container container;
    private final JMenuItem menuItemHelp;
    private final JMenuItem menuItemExit;
    private final JMenuItem menuItemListStudents;

    public MainFrame() {
        this.container = this.getContentPane();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Driving School Management");

        JPanel panel = new JPanel(new GridLayout(4, 3));
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");


        this.menuItemListStudents = new JMenuItem("List Students");
        menu.add(this.menuItemListStudents);
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

    void showHelpPane() {
        JPanel helpPanel = new JPanel();
        this.container.removeAll();
        this.container.add(helpPanel);
    }

    public void addActionListenerForListStudentsMenu(ActionListener l) {
        this.menuItemListStudents.addActionListener(l);
    }

    public void addActionListenerForHelpMenu(ActionListener l) {
        this.menuItemHelp.addActionListener(l);
    }

    /**
     * Add an ActionListener for the exit menu
     * @param l
     */
    public void addActionListenerForExitMenu(ActionListener l) {
        this.menuItemExit.addActionListener(l);
    }
}
