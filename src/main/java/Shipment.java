import products.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Noel on 20/02/2018.
 */
public class Shipment implements Iterable<Product>{
    
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    final static int PRODUCT_NOT_FOUND = -1;
    
    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts = new ArrayList<>();
    private List<Product> heavyVanProducts = new ArrayList<>();

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {

       final int index = products.indexOf(oldProduct);

        if (index != PRODUCT_NOT_FOUND)
             products.set(index, newProduct);

    }

    public void prepare() {
        products.sort(Product.BY_WEIGHT);

        final int splitPoint = findSplitPoint();
        lightVanProducts = products.subList(0,splitPoint);
        heavyVanProducts = products.subList(splitPoint,products.size());


    }

    private int findSplitPoint() {
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getWeight() > LIGHT_VAN_MAX_WEIGHT)
                    return i;
        }

        return 0;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }
}
