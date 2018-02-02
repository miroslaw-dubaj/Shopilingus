public class Product {
    private String name;
    private double price;
    private String type;
    private String size;
    private double weight;
    private double tax;

    public String getName() {
        return name;
    }

    public Product(String name, double price) {
        this(name, price, "product", "N/A", 0.0, 0.23);
    }

    public Product(String name, double price, String type, String size, double weight, double tax){
        this.name = name;
        this.price = price;
        this.type = type;
        this.size = size;
        this.weight = weight;
        this.tax = tax;
    }


}

