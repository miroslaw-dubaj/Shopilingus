public class Employee {

    // ********** Static Fields **********

    private static int nextId = 0;

    // ********** End of Static Fields **********

    // ********** Fields **********

    private String name;
    private String[] skills;
    private boolean isAvailable;
    private int id;

    // ********** End of Fields **********

    // ********** Constructor for Employee **********

    public Employee(String name, String[] skills, boolean isAvailable) {
        this.name = name;
        this.skills = skills;
        this.isAvailable = isAvailable;
        this.id = Employee.nextId;
    }

    // ********** End of Constructor for Employee **********

    // ********** Getters & Setters **********

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // ********** End of Getters & Setters **********

    // ********** Methods for Employee **********

    public boolean isAvailable() {
        return isAvailable;
    }

    // ********** End of Methods **********
}
