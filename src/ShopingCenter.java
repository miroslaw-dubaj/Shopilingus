import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShopingCenter {

// *********** Static fields **********

    private static int nextId = 0;

// *********** End of Static fields ***********

// *********** Fields ************

    private String name;
    private Address address;
    private List<Shop> shopList;
    private OpeningHours timeOpen;
    private int id;

// ********** End of fields ************

// ********** Constructors for ShoppingCenter ***********

    public ShopingCenter(String name, Address address, OpeningHours timeOpen) {
        this.name = name;
        this.address = address;
        this.shopList = new LinkedList<Shop>();
        this.timeOpen = timeOpen;
        this.id = ShopingCenter.nextId++;
    }

    public ShopingCenter(String name, String address, int openTime, int closeTime) {
        this(name, new Address(address), new OpeningHours(openTime, closeTime));
    }

// *********** End of Constructors ***********

// ************ Getters and Setters **********

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

// ********** End of G & S ***********

// ********** Methods - CRUD for Shops **********
    public void addShop(Shop newShop) {
        shopList.add(newShop);
    }

    public Shop getShop(int shopId) {
        for (Shop aShopList : shopList) {
            if (aShopList.getId() == shopId) {
                return aShopList;
            }
        }
        System.out.println("Shop not found.");
        return null;
    }

    public void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.setId(shopId);
        addShop(modifiedShop);
    }

    public void deleteShop(int id) {
        Shop toDelete = getShop(id);
        if (toDelete != null) {
            shopList.remove(toDelete);
        }
    }
// ********** End of Methods - CRUD fo Shops **********

// ********** Methods - Shops **********

    public List<Shop> findShopsByName(String name) {
        return shopList.stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }

    public void displayShopList() {
        int i = 1;
        for (Shop shop : shopList) {
            System.out.println(i + ". " + shop.getName() + " - ID: " + shop.getId());
            i++;
        }
    }

    public List<ProductDetails> getAllProducts() {
        List<ProductDetails> allProducts = new LinkedList<ProductDetails>();
        for (Shop shop : shopList) {
            allProducts.addAll(shop.getProducts());
        }
        return allProducts;
    }

    public List<Service> getAllServices(){
        List<Service> allServices = new LinkedList<Service>();
        for (Shop shop: shopList) {
            allServices.addAll(shop.getServices());
        }
        return allServices;
    }

    public Set<String> getAllShopTypes() {
        return this.shopList.stream()
                .flatMap(shop -> shop.getTypes().stream())
                .collect(Collectors.toSet());
    }

    public Set<String> getAllProductTypes() {
        return this.getAllProducts().stream()
                .map(productDetails -> productDetails.getProduct().getType())
                .collect(Collectors.toSet());
    }

    // ********** End of Methods - Shops ***********

// ********** Methods - ShoppingCentre **********

    public OpeningHours getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(OpeningHours timeOpen) {
        this.timeOpen = timeOpen;
    }

// *********** End of Methods - ShoppingCentre ***********
}
