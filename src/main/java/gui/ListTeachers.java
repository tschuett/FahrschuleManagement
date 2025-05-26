package gui;

import javax.swing.*;

class ListTeachers extends JScrollPane {

    ListTeachers() {
        ListTeachersTableModel model = new ListTeachersTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
    }
}
