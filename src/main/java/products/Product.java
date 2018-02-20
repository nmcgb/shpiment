package products;

import java.util.Comparator;

import static java.util.Comparator.comparing;

/**
 * Created by Noel on 20/02/2018.
 */
public class Product {
    public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);
    private final String type;
    private final int weight;

    public int getWeight() {
        return weight;
    }

    public Product(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }


}
