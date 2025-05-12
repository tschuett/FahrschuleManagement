package Database;

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

    public Object at(int index) {
        switch (index) {
           case 0: return id;
           case 1: return firstName;
           case 2: return lastName;
           case 3: return email;
           default: return null;
        }
    }
}
