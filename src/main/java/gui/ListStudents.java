package gui;

import javax.swing.*;

public class ListStudents extends JScrollPane {

    ListStudents() {
        ListStudentsTableModel model = new ListStudentsTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
    }
}
