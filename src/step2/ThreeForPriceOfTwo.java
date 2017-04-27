package step2;

import java.util.List;

public class ThreeForPriceOfTwo implements SpecialOffer {
    @Override
    public double computePrice(List<Item> items) {
        int count = items.size();
        double unitPrice = items.get(0).getPrice();
        return count / 3 * 2 * unitPrice + count % 3 * unitPrice;
    }
}
