package test.checkout.counter.step1;

import java.util.List;

public class CheckoutSession {
    public double scanItems(List<Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
