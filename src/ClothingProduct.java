public class ClothingProduct extends Product {

    // ********** Fields **********

    private ClothingSizes size;

    // ********** End of Fields **********

    // ********** Constructor for ClothingProduct **********

    public ClothingProduct(String name, double price, ClothingSizes size) {
        super(name, price, ProductTypes.CLOTHING, 0.23);
        this.size = size;
    }

    // ********** End of Constructor for ClothingProduct **********

    // ********** Getters & Setters **********

    public ClothingSizes getSize() {
        return size;
    }

    public void setSize(ClothingSizes size) {
        this.size = size;
    }


    // ********** End of Getters & Setters **********

    // ********** Methods for ClothingProduct **********

    @Override
    public String getFullName() {
        return this.getName() + " - " + this.getSize();
    }

    // ********** End of Methods for ClothingProduct **********

}

