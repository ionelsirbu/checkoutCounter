package test.checkout.counter.step1;

import org.junit.Before;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class CheckoutSessionTest {
    private CheckoutSession checkoutSession;

    @Before
    public void setup() {
        checkoutSession = new CheckoutSession();
    }

    @org.junit.Test
    public void scanItems() throws Exception {
        List<Item> itemsToScan = Stream.of(new Apple(), new Apple(), new Orange(), new Apple()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(2.05, totalPrice, 1e-3);
    }

}