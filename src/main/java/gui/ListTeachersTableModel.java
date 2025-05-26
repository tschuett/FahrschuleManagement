package gui;

import Database.Teacher;
import Database.Teachers;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Model a list of teachers for a JTable
 */
class ListTeachersTableModel extends AbstractTableModel {
    private final List<Teacher> teachers;

    ListTeachersTableModel() {
        Teachers teachersDAO = new Teachers();
        this.teachers = teachersDAO.listTeachers();
    }

    @Override
    public int getRowCount() {
        return teachers.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return teachers.get(rowIndex).at(columnIndex);
    }
}
