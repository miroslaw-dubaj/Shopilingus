public class ProductDetails {

    // ************ Fields **********

    private Product product;
    private double quantity;

    // ************ End of Fields **********

    // ************ Constructors for Product Details **********

    public ProductDetails(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // ************ End of Constructors for Product Details **********

    // ************ Getters & Setters **********

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // ************ End of Getters & Setters **********

}
