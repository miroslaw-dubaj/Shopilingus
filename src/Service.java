public class Service {
    private String name;
    private double price;
    private Integer duration;
    private String skillNeeded;
    private int id;
    private static int nextId = 0;

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

    public Service(String name, double price, Integer duration, String skillNeeded) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.skillNeeded = skillNeeded;
        this.id = Service.nextId;
    }
}
