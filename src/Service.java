public class Service {

    // ************ Static Fields **********

    private static int nextId = 0;

    // ************ End of Static Fields **********

    // ************ Fields **********

    private String name;
    private double price;
    private Integer duration;
    private String skillNeeded;
    private int id;

    // ************ End of Static Fields **********

    // ************ Constructors for Service **********

    public Service(String name, double price, Integer duration, String skillNeeded) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.skillNeeded = skillNeeded;
        this.id = Service.nextId++;
    }

    // ************ End of Constructors for Service **********

    // ************ Getters & Setters **********

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getSkillNeeded() {
        return skillNeeded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ************ End of Getters & Setters **********
}
