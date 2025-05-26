package Database;

/// Represents a row in the student's table.
public record Student(int id, String firstName, String lastName, String email) {

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    /// Index for abstract tables @see javax.swing.table.AbstractTableModel
    public Object at(int index) {
        return switch (index) {
            case 0 -> id;
            case 1 -> firstName;
            case 2 -> lastName;
            case 3 -> email;
            default -> null;
        };
    }
}
