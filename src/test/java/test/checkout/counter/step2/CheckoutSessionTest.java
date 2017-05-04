package test.checkout.counter.step2;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class CheckoutSessionTest {
    private CheckoutSession checkoutSession;

    @Before
    public void setup() {
        Map<Integer, SpecialOffer> specialOffers = new HashMap<>(2);
        specialOffers.put(new Apple().getUid(), new BuyOneGetOneFree());
        specialOffers.put(new Orange().getUid(), new ThreeForPriceOfTwo());
        checkoutSession = new CheckoutSession(specialOffers);
    }

    @Test
    public void scan1Apple() throws Exception {
        List<Item> itemsToScan = Stream.of(new Apple()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(0.6, totalPrice, 1e-3);
    }

    @Test
    public void scan2Apples() throws Exception {
        List<Item> itemsToScan = Stream.of(new Apple(), new Apple()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(0.6, totalPrice, 1e-3);
    }

    @Test
    public void scan3Apples() throws Exception {
        List<Item> itemsToScan = Stream.of(new Apple(), new Apple(), new Apple()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(1.2, totalPrice, 1e-3);
    }

    @Test
    public void scan2Oranges() throws Exception {
        List<Item> itemsToScan = Stream.of(new Orange(), new Orange()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(0.5, totalPrice, 1e-3);
    }

    @Test
    public void scan3Oranges() throws Exception {
        List<Item> itemsToScan = Stream.of(new Orange(), new Orange(), new Orange()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(0.5, totalPrice, 1e-3);
    }

    @Test
    public void scan4Oranges() throws Exception {
        List<Item> itemsToScan = Stream.of(new Orange(), new Orange(), new Orange(), new Orange()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(0.75, totalPrice, 1e-3);
    }

    @Test
    public void scanItems() throws Exception {
        List<Item> itemsToScan = Stream.of(new Apple(), new Apple(), new Orange(), new Apple()).collect(toList());
        double totalPrice = checkoutSession.scanItems(itemsToScan);
        assertEquals(1.45, totalPrice, 1e-3);
    }

}