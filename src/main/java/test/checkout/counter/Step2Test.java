package test.checkout.counter;

import test.checkout.counter.step2.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Step2Test {
    private static final Map<String, Item> itemsByName = new HashMap<>(2);

    static {
        itemsByName.put("Apple", new Apple());
        itemsByName.put("Orange", new Orange());
    }

    static void testItems(String[] args) {
        List<Item> itemsToCheckout = new ArrayList<>(args.length);
        for (String arg : args) {
            Item item = itemsByName.get(arg);
            if (item != null) {
                itemsToCheckout.add(item);
            } else {
                System.out.println("Item not recognized: " + arg);
            }
        }
        Map<Integer, SpecialOffer> specialOffers = new HashMap<>(2);
        specialOffers.put(new Apple().getUid(), new BuyOneGetOneFree());
        specialOffers.put(new Orange().getUid(), new ThreeForPriceOfTwo());
        CheckoutSession checkoutSession = new CheckoutSession(specialOffers);
        double totalToPay = checkoutSession.scanItems(itemsToCheckout);
        System.out.println("Step 2 - total sum to pay: " + totalToPay);
    }
}
