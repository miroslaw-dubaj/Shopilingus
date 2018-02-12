public class Product {

    // ********** Static Fields **********

    private static int nextId = 0;

    // ********** End of Static Fields **********

    // ********** Fields **********

    private String name;
    private double price;
    private ProductTypes type;
    private double tax;
    private int id;

    // ********** End of Fields **********

    // ********** Constructor for Product **********

    public Product(String name, double price) {
        this(name, price, ProductTypes.UNKNOWN, 0.23);
    }

    public Product(String name, double price, ProductTypes type, double tax){
        this.name = name;
        this.price = price;
        this.type = type;
        this.tax = tax;
        this.id = Product.nextId;
    }

    // ********** End of Constructors for Product **********

    // ********** Getters & Setters **********

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name;
    }

    public ProductTypes getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNettoPrice() {
        return price;
    }

    public double getBruttoPrice() {
        return price + (price * tax);
    }

    // ********** End of Getters & Setters **********
}

