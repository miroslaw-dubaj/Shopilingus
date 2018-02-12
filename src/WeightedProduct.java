public class WeightedProduct extends Product {

    // ********** Fields **********

    private double weight;

    // ********** End of Fields **********

    // ********** Constructor for WeightedProduct **********

    public WeightedProduct(String name, double price, double weight) {
        super(name, price, ProductTypes.UNKNOWN, 0.23);
        this.weight = weight;
    }

    // ********** End of Constructor for WeightedProduct **********

    // ********** Getters & Setters **********

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    // ********** End of Getters & Setters **********

    // ********** Methods for WeightedProduct **********

    @Override
    public double getNettoPrice() {
        return super.getNettoPrice() * this.getWeight();
    }

    @Override
    public double getBruttoPrice() {
        return super.getBruttoPrice() * this.getWeight();
    }

    // ********** End of Methods for WeightedProduct **********
}
