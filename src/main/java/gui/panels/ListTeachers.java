package gui.panels;

import javax.swing.*;

public final class ListTeachers extends JScrollPane {

    public ListTeachers() {
        ListTeachersTableModel model = new ListTeachersTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
    }
}
