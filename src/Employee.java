public class Employee {
    private String name;
    private String[] skills;
    private boolean isAvailable;

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
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
    }
}
