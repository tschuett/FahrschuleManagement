package Database;

/// Represents a row in the teacher's table.
public record Teacher (int id, String firstName, String lastName, String email) {

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
