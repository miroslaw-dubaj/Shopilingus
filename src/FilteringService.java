import java.lang.reflect.Array;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringService {

    public List<Shop> filterShops(FilteringParams params, ShopingCenter shopingCenter) {
        List<Shop> filterResult = filterByProductId(params, shopingCenter.getShopList());
        return filterResult;
    }

    private List<Shop> filterByShopId(FilteringParams params, List<Shop> result) {
        for (Shop shop : result) {
            if (params.getShopIds().contains(shop.getId())) {
                result.add(shop);
            }
        }
        return result;
    }

    private List<Shop> filterByShopType(FilteringParams params, List<Shop> result) {
        for (Shop shop : result) {
            if (!(Collections.disjoint(shop.getTypes(), params.getTypes()))) {
                result.add(shop);
            }
        }
        return result;
    }

    private List<Shop> filterByProductId(FilteringParams params, List<Shop> result) {
        for (Shop shop : result) {
            List<Integer> shopProductsIds = shop.getProducts().stream()
                    .map(productDetails -> productDetails.getProduct().getId())
                    .collect(Collectors.toList());
            if (!(Collections.disjoint(params.getProductIds(), shopProductsIds))) {
                result.add(shop);
            }
        }
        return result;
    }

    private List<Shop> filterByPriceRange(FilteringParams params, List<Shop> result) {
        for (Shop shop : result) {
            List<Shop> tempResult = shop.getProducts().stream()
                    .filter(productDetails -> {
                         double price = productDetails.getProduct().getNettoPrice();
                         return price > params.getPriceRangeMin() && price < params.getPriceRangeMin()
                    });
            result.addAll(tempResult);
        }
        return result;
    }

// TODO all other filters
//    private List<Integer> filterByFloors(FilteringParams params, List<Shop> result) {
//        return result;
//    }
}




