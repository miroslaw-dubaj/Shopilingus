public class Product {
    private String name;
    private double price;
    private String type;
    private String size;
    private double weight;
    private double tax;
    private int id;
    private static int nextId = 0;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.id = Product.nextId;
    }


}

