public class Employee {
    private String name;
    private String[] skills;
    private boolean isAvailable;
    private int id;
    private static int nextId = 0;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Employee(String name, String[] skills, boolean isAvailable) {
        this.name = name;
        this.skills = skills;
        this.isAvailable = isAvailable;
        this.id = Employee.nextId;
    }
}
