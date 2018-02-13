import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Constructor for Employee - string 'name', string array 'skills', boolean 'isAvailable'
        // Constructor for Service - String 'name', double 'price', Integer 'duration', String 'skillNeeded'
        // ServiceDetails Constructor - Service 'service', Employee 'name', Integer 'duration'
        // Constructor for Product - String 'name', double 'price', String 'type', String 'size', double 'weight'
        Shop Centero = new Shop("Centero", 1,2);
        Centero.addProduct(new Product("Soda", 3.5, "Beverage", "1 L", 1.0, 0.23), 2);
        Centero.hire(new Employee("John Doe", new String[]{"Cashier", "Manager", "Knifemaking"}, true));
        Centero.addService(new Service("Sharpening", 10, 1, "Knifemaking"));
        Centero.buyProduct("Soda");
        Centero.buyService("Sharpening");
        shopApp(Centero);
    }

    public static void shopApp(Shop name) {
        String data = "";
        Scanner read = new Scanner(System.in);
        displayMenu(name);
        while (!data.equals("quit")) {
            System.out.println("ENTER INPUT:");
            data = read.nextLine().toLowerCase();
            if (data.equals("products")) {
                System.out.println("Products available:");
                for (int i = 0; i < name.getProducts().size(); i++) {
                    System.out.println((i + 1) + ". " + name.getProducts().get(i).getProduct().getName() + " - " + name.getProducts().get(i).getQuantity() + " pcs");
                }
            } else if (data.equals("services")) {
                System.out.println("Services provided:");
                for (int i = 0; i < name.getServices().size(); i++) {
                    System.out.println((i + 1) + ". " + name.getServices().get(i).getName() + " - duration: " + name.getServices().get(i).getDuration() + " minutes");
                }
            } else if (data.equals("employees")) {
                System.out.println("Employees:");
                for (int i = 0; i < name.getEmployees().size(); i++) {
                    String skilledWorker = "";
                    for (int j = 0; j < name.getEmployees().get(i).getSkills().length; j++) {
                        if (j == name.getEmployees().get(i).getSkills().length - 1) {
                            skilledWorker += name.getEmployees().get(i).getSkills()[j];
                        } else {
                            skilledWorker += name.getEmployees().get(i).getSkills()[j] + " - ";
                        }
                    }
                    System.out.println((i + 1) + ". " + name.getEmployees().get(i).getName() + " - skills: " + skilledWorker + " | Available: " + name.getEmployees().get(i).isAvailable());
                }
            } else if (data.equals("occupied")) {
                for (int i = 0; i < name.getCurrentServicesUnavailable().size(); i++) {
                    System.out.println((i + 1) + ". Performing: " + name.getCurrentServicesUnavailable().get(i).getService().getName() + " - " + name.getCurrentServicesUnavailable().get(i).getName().getName() + " - duration: " + name.getCurrentServicesUnavailable().get(i).getDuration() + " minutes.");
                }
            } else if (data.equals("menu")) {
                displayMenu(name);
            } else if (!data.equals("quit")) {
                System.out.println("Wrong input.");
            }
        }
        System.out.println("Program finished.");
        }

        public static void displayMenu(Shop name) {
        System.out.println("***" + name.getName() + " - DISPLAY LIST ***");
        System.out.println("Type \"Products\" for products list.");
        System.out.println("Type \"Services\" for services list.");
        System.out.println("Type \"Employees\" for employees list.");
        System.out.println("Type \"Occupied\" for list of employees currently performing a service.");
        System.out.println("Type \"Menu\" for this menu to display.");
        System.out.println("Type \"Quit\" to end program.");

    }
}


