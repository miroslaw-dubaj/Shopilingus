public class ServiceDetails {

    // ************ Fields **********

    private Service service;
    private Employee name;
    private Integer duration;

    // ************ End of Fields **********

    // ************ Constructors for Service Details **********

    public ServiceDetails(Service service, Employee name, Integer duration) {
        this.service =  service;
        this.name = name;
        this.duration = duration;
    }

    // ************ End of Constructors for Service Details **********

    // ************ Getters & Settters **********

    public Service getService() {
        return this.service;
    }

    public Employee getName() {
        return this.name;
    }

    public Integer getDuration() {
        return this.duration;
    }

    // ************ End of Getters & Setters **********
}
