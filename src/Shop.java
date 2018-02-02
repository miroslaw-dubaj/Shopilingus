import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Shop {
    private String name;
    private String address;
    private List<ProductDetails> products;
    private String[] type;
    private List<Service> services;
    private List<ServiceDetails> currentServicesUnavailable;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public String[] getType() {
        return type;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<ServiceDetails> getCurrentServicesUnavailable() {
        return currentServicesUnavailable;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // Constructor for Product - String 'name', double 'price', String 'type', String 'size', double 'weight'
    public void addProduct(Product product, double quantity) {
        ProductDetails newProduct = new ProductDetails(product,quantity);
        products.add(newProduct);
    }

    // Constructor for Employee - string 'name', string array 'skills', boolean 'isAvailable'
    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (name.equals(employees.get(i).getName())) {
                employees.remove(i);
            }
        }
    }

    // Constructor for Service - String 'name', double 'price', Integer 'duration', String 'skillNeeded'
    public void addService(Service service) {
        services.add(service);
    }

    public boolean isEmployeeAvailable(String skillNeeded) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isAvailable()) {
                for (int j = 0; j < employees.get(i).getSkills().length; j++) {
                    if (employees.get(i).getSkills()[j] == skillNeeded) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Employee FindEmployeeAvailable(String skillNeeded) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isAvailable()) {
                for (int j = 0; j < employees.get(i).getSkills().length; j++) {
                    if (employees.get(i).getSkills()[j] == skillNeeded) {
                        return employees.get(i);
                    }
                }
            }
        }
        return null;
    }

    public boolean isProductAvailable(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProduct().getName() == name && products.get(i).getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    public void buyProduct(String name) {
        if (isProductAvailable(name)) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProduct().getName() == name) {
                    products.get(i).setQuantity(products.get(i).getQuantity() - 1);
                }
            }
        }
    }

                // ServiceDetails Constructor - Service 'service', Employee 'name', Integer 'duration', Integer 'timeOfStart'
    public void buyService(String name) {
        int serviceDuration = 0;
        for (int i = 0; i < services.size(); i++) {
            Employee employeeToWork = FindEmployeeAvailable(services.get(i).getSkillNeeded());
            if (name == services.get(i).getName() && employeeToWork != null) {
                serviceDuration = services.get(i).getDuration();
                ServiceDetails newService = new ServiceDetails(services.get(i), employeeToWork, services.get(i).getDuration()); //, timeOfStart);
                currentServicesUnavailable.add(newService);
                for (int j = 0; j < employees.size(); j++) {
                    if (employees.get(j) == employeeToWork) {
                        employees.get(j).setAvailable(false);
                    }
                }
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Employee: " + employeeToWork.getName() + " finished performing: " + newService.getService().getName() + " and is available for work.");
                        employeeToWork.setAvailable(true);
                        currentServicesUnavailable.remove(newService);
                    }
                }, serviceDuration*60*1000);
            }
        }
    }



     public Shop(String name, String address) {
        this.name = name;
        this.address = address;
        this.employees = new LinkedList<>();
        this.products = new LinkedList<>();
        this.services = new LinkedList<>();
        this.type = null;
        this.currentServicesUnavailable = new LinkedList<>();
    }
}

