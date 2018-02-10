import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Shop {

    // *********** Static fields **********

    private static int nextId = 0;

    // *********** End of Static fields ***********

    // *********** Fields ************

    private String name;
    private Address address;
    private List<ProductDetails> products;
    private List<String> types;
    private List<Service> services;
    private List<ServiceDetails> currentServicesUnavailable;
    private List<Employee> employees;
    private int id;

    // ********** End of fields ************

    // ********** Constructors for Shop ***********

    public Shop(String name, int floor, int box) {
        this.name = name;
        this.address = new Address(floor, box);
        this.employees = new LinkedList<Employee>();
        this.products = new LinkedList<ProductDetails>();
        this.services = new LinkedList<Service>();
        this.types = new LinkedList<String>();
        this.currentServicesUnavailable = new LinkedList<>();
        this.id = Shop.nextId++;
    }

    // *********** End of Constructors ***********

    // ************ Getters and Setters **********

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<ProductDetails> getProducts() {
        return products;
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

    public List<String> getTypes() {
        return types;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ********** End of G & S ***********

    // ********** Methods & CRUD for Products **********
    // Constructor for Product - String 'name', double 'price', String 'type', String 'size', double 'weight'

    private ProductDetails findProductById(int id) {
        for (ProductDetails productDetails : products) {
            if (productDetails.getProduct().getId() == id) {
                return productDetails;
            }
        }
        return null;
    }

    public void addProduct(Product product, double quantity) {
        if (findProductById(product.getId()) != null) {
            findProductById(product.getId()).setQuantity(quantity);
        }
        if (findProductById(product.getId()) == null) {
            ProductDetails newProduct = new ProductDetails(product, quantity);
            products.add(newProduct);
        }
    }

    public void deleteProduct(int id) {
        ProductDetails toDelete = findProductById(id);
        if (toDelete != null)
            products.remove(toDelete);
    }

    public Product getProduct(int id) {
        ProductDetails searchedProduct = findProductById(id);
        if (searchedProduct != null) {
            return searchedProduct.getProduct();
        }
        return null;
    }

    public void updateProduct(int id, Product product) {
        ProductDetails toUpdate = findProductById(id);
        if (toUpdate != null) {
            product.setId(id);
            toUpdate.setProduct(product);
        }
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

    // ********** End of Methods & CRUD for Products ***********

    // ********** Methods & CRUD for Employees **********
    // Constructor for Employee - string 'name', string array 'skills', boolean 'isAvailable'
    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(int id) {
        if (findEmployeeById(id) != null) {
            employees.remove(findEmployeeById(id));
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
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

    public void updateEmployee(int id, Employee employee) {
        if (findEmployeeById(id) != null) {
            employee.setId(id);
            employees.remove(findEmployeeById(id));
            employees.add(employee);
        }
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

    public int getNumberOfEmployees() {
        int counter = 0;
        for (Employee employee: employees) {
            counter++;
        }
        return counter;
    }

    // ********** End of Methods & CRUD for Employees ***********

    // ********** Methods - Crud for Services **********
    // Constructor for Service - String 'name', double 'price', Integer 'duration', String 'skillNeeded'
    public void addService(Service service) {
        services.add(service);
    }

    public Service findServiceById(int id) {
        for (Service service: services) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    public void deleteService(int id) {
        Service toDelete = findServiceById(id);
        if (toDelete != null) {
            services.remove(toDelete);
        }
    }

    public void updateService(int id, Service service) {
        Service toUpdate = findServiceById(id);
        if (toUpdate != null) {
            services.remove(findServiceById(id));
            service.setId(id);
            services.add(service);
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
                }, serviceDuration * 60 * 1000);
            }
        }
    }

    // ********** End of Methods & CRUD for Services ***********
}

