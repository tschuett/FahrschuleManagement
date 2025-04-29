public class Student {
    private int id;
    private String firstname;
    private String lastname;

    public Student(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    int getId() {   return id;   }
    String getFirstname() {   return firstname;   }
    String getLastname() {   return lastname;   }

}
