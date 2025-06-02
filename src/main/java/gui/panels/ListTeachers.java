package gui.panels;

import javax.swing.*;
import java.awt.*;

public final class ListTeachers extends JScrollPane {

    public ListTeachers() {
        ListTeachersTableModel model = new ListTeachersTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
        setBackground(Color.LIGHT_GRAY);
    }
}
