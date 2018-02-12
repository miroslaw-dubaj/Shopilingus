import com.sun.deploy.ui.ProgressDialog;

import java.util.List;

public class FilteringParams {

    // ********** Fields **********

    private List<Integer> shopIds;
    private List<ShopTypes> types;
    private List<Integer> productIds;
    private double priceRangeMin;
    private double priceRangeMax;
    private List<Integer> floors;
    private boolean isOpen;
    private int serviceDuration;
    private int maxWaithingTime;
    private List<ClothingSizes> sizes;
    private List<ProductTypes> productTypes;

    // ********** End of Fields **********

    // ********** Constructor for FilteringParams **********



    // ********** End of Constructor for FilteringParams **********

    // ********** Getters & Setters **********

    public List<Integer> getShopIds() {
        return shopIds;
    }

    public List<ShopTypes> getTypes() {
        return types;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public double getPriceRangeMin() {
        return priceRangeMin;
    }

    public double getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<Integer> getFloors() {
        return floors;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getServiceDuration() {
        return serviceDuration;
    }

    public int getMaxWaithingTime() {
        return maxWaithingTime;
    }

    public List<ClothingSizes> getSizes() {
        return sizes;
    }

    public List<ProductTypes> getProductTypes() {
        return productTypes;
    }

    // ********** End of Getters & Setters **********
}
