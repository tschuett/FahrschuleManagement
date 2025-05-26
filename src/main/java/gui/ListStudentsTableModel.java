package gui;

import Database.Student;
import Database.Students;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Model a list of students for a JTable
 */
class ListStudentsTableModel extends AbstractTableModel {
    private final List<Student> students;

    ListStudentsTableModel() {
        Students dao = new Students();
        this.students = dao.listStudents();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return students.get(rowIndex).at(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Vorname";
            case 2 -> "Nachname";
            case 3 -> "E-Mail";
            default -> "Unbekannt";
        };
    }
}
