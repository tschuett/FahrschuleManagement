package gui.panels;


import javax.swing.*;
import java.awt.*;

public final class ListStudents extends JScrollPane {

    public ListStudents() {
        ListStudentsTableModel model = new ListStudentsTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
        setBackground(Color.DARK_GRAY);
    }
}
