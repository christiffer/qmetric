package kata.supermarket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscountService {

    // Backed by a List but really this would be backed by a Repository.
    final Set<ActiveDiscount> activeDiscounts = new HashSet<>();

    List<Discount> discountsFor(List<Item> items) {
        return activeDiscounts.stream()
                .map(ad -> ad.discountFor(items))
                .flatMap(List::stream)
                .toList();
    }

    boolean addDiscount(ActiveDiscount discount) {
        return this.activeDiscounts.add(discount);
    }

    boolean removeDiscount(ActiveDiscount discount) {
        return this.activeDiscounts.remove(discount);
    }
}
