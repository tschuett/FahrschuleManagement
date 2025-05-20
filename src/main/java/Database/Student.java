package Database;

/// Represents a row in the student's table.
public final class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;

    Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
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
