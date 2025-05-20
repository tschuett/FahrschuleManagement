package Database;

/// Represents a row in the teacher's table.
public final class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    Teacher(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /// Index for abstract tables for JTables.
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
