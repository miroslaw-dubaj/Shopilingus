import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FoodProduct extends Product {

    // ********** Fields **********

    private List<String> ingredients;

    // ********** End of Fields **********

    // ********** Constructor for FoodProduct **********

    public FoodProduct(String name, double price, List<String> ingredients) {
        super(name, price, ProductTypes.FOOD, 0.07);
        this.ingredients = ingredients;
    }

    public FoodProduct(String name, double price, String... ingredients) {
        this(name, price, Arrays.asList(ingredients));
    }

    // ********** End of Constructor for FoodProduct **********

    // ********** Getters & Setters **********

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    // ********** End of Getters & Setters **********

    // ********** Methods for FoodProduct **********

    @Override
    public String getFullName() {
        return this.getName() + " - " + this.getIngredients().stream().collect(Collectors.joining(", "));
    }

    // ********** End of Methods for FoodProduct **********

}
