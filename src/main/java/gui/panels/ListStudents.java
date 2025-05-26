package gui.panels;


import javax.swing.*;

public final class ListStudents extends JScrollPane {

    public ListStudents() {
        ListStudentsTableModel model = new ListStudentsTableModel();
        JTable table = new JTable(model);
        setViewportView(table);
        table.setFillsViewportHeight(true);
    }
}
