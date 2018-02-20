package products;

/**
 * Created by Noel on 20/02/2018.
 */
public class ProductFixtures {

    public static Product door = new Product("wooden door", 35);
    public static Product floorPanel = new Product("floor panel", 25);
    public static Product window = new Product("glass window", 10);

    public static Supplier bobs = new Supplier("bobs supplies");
    public static Supplier kates = new Supplier("kates home goods");

    static {
        bobs.products().add(door);
        bobs.products().add(floorPanel);

        kates.products().add(floorPanel);
        kates.products().add(door);
    }
}
