package gui;

import java.awt.event.ActionEvent;

public class MainController {
    private MainFrame view;

    MainController() {
        this.view = new MainFrame();
        this.view.addActionListenerForHelpMenu(this::listenHelpMenu);
        this.view.addActionListenerForExitMenu(this::listenExitMenu);
    }

    /**
     * Listen for uses of the help menu entry. Print help text.
     * @param event
     */
    void listenHelpMenu(ActionEvent event) {
        //JTextArea out = this.view.getShowOutput();

        StringBuilder sb = new StringBuilder();
        sb.append("Enter from/to accounts").append("\n");
        sb.append("Enter money amount").append("\n");

        //out.setText(sb.toString());
    }

    /**
     * Listen for uses of the exit menu entry.
     * @param event
     */
    void listenExitMenu(ActionEvent event) {
        System.exit(0);
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
    }
}
