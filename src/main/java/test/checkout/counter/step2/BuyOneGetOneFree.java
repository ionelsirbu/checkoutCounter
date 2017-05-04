package test.checkout.counter.step2;

import java.util.List;

public class BuyOneGetOneFree implements SpecialOffer {
    @Override
    public double computePrice(List<Item> items) {
        return (items.size() + 1) / 2 * items.get(0).getPrice();
    }
}
