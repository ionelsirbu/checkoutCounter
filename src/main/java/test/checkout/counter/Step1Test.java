package test.checkout.counter;

import test.checkout.counter.step1.Apple;
import test.checkout.counter.step1.CheckoutSession;
import test.checkout.counter.step1.Item;
import test.checkout.counter.step1.Orange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Step1Test {
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
        CheckoutSession checkoutSession = new CheckoutSession();
        double totalToPay = checkoutSession.scanItems(itemsToCheckout);
        System.out.println("Step 1 - total sum to pay: " + totalToPay);
    }
}
