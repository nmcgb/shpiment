
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static products.ProductFixtures.door;
import static products.ProductFixtures.floorPanel;
import static products.ProductFixtures.window;

/**
 * Created by Noel on 20/02/2018.
 */
public class ShipmentTest {

    Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems(){
        shipment.add(door);
        shipment.add(window);

    assertThat(shipment,  hasItems(door, window));

    }
    @Test
    public void shouldReplaceItems(){
        shipment.add(door);
        shipment.add(window);

        shipment.replace(door, floorPanel);

        assertThat(shipment, hasItems(floorPanel, window));
    }

    @Test
    public void shouldNotReplaceMissingItems(){
        shipment.add(window);

        shipment.replace(door, floorPanel);

        assertThat(shipment, hasItem(window));
    }

    @Test
    public void shouldIdentifyVanRequirements(){
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        assertThat(shipment.getLightVanProducts(), hasItem(window));
        assertThat(shipment.getHeavyVanProducts(), hasItems(floorPanel, door));
    }
}
