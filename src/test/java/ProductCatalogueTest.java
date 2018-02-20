import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static products.ProductFixtures.bobs;
import static products.ProductFixtures.door;
import static products.ProductFixtures.kates;

/**
 * Created by Noel on 20/02/2018.
 */
public class ProductCatalogueTest {
    @Test
    public void shouldOnlyHaveUniqueProducts() throws Exception {
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue, hasItem(door));

    }
}