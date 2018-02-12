public class PharmacyProduct extends Product {

    // ********** Fields **********

    private double nfzRefund = 0.7;
    private String latinName;

    // ********** End of Fields **********

    // ********** Constructor for PharmacyProduct **********

    public PharmacyProduct(String name, double price, double nfzRefund, String latinName) {
        super(name, price, ProductTypes.DRUG, 0.23);
        this.nfzRefund = nfzRefund;
        this.latinName = latinName;
    }

    public PharmacyProduct(String name, double price, String latinName) {
        this(name, price, 0.7, latinName);
    }

    // ********** End of Constructor for PharmacyProduct **********

    // ********** Getters & Setters **********

    public double getNfzRefund() {
        return nfzRefund;
    }

    public void setNfzRefund(double nfzRefund) {
        this.nfzRefund = nfzRefund;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    // ********** End of Getters & Setters **********

    // ********** Methods for PharmacyProduct **********

    @Override
    public String getFullName() {
        return this.getName() + " - " + this.getLatinName();
    }

    @Override
    public double getNettoPrice() {
        return super.getNettoPrice() - (super.getNettoPrice() * this.getNfzRefund());
    }

    @Override
    public double getBruttoPrice() {
        return super.getBruttoPrice() - (super.getBruttoPrice() * this.getNfzRefund());
    }

    // ********** End of Methods for PharmacyProduct **********

}
