public class ServiceDetails {
    private Service service;
    private Employee name;
    private Integer duration;

    public Service getService() {
        return this.service;
    }

    public Employee getName() {
        return this.name;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public ServiceDetails(Service service, Employee name, Integer duration) {
        this.service =  service;
        this.name = name;
        this.duration = duration;
    }
}
