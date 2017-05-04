package test.checkout.counter.step2;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CheckoutSession {
    private Map<Integer, SpecialOffer> specialOffers;

    public CheckoutSession(Map<Integer, SpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }

    public double scanItems(List<Item> items) {
        Map<Integer, List<Item>> itemsUnderOffer = items.stream()
                .filter(item -> specialOffers.containsKey(item.getUid()))
                .collect(groupingBy(Item::getUid));
        double specialOfferTotal = itemsUnderOffer.entrySet().stream()
                .mapToDouble(entry -> specialOffers.get(entry.getKey()).computePrice(entry.getValue()))
                .sum();
        double regularTotal = items.stream()
                .filter(item -> !specialOffers.containsKey(item.getUid()))
                .mapToDouble(Item::getPrice).sum();
        return specialOfferTotal + regularTotal;
    }
}
