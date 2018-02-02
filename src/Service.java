public class Service {
    private String name;
    private double price;
    private Integer duration;
    private String skillNeeded;

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getSkillNeeded() {
        return skillNeeded;
    }

    public Service(String name, double price, Integer duration, String skillNeeded) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.skillNeeded = skillNeeded;
    }
}
