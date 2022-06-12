package kata.supermarket;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Buy One, Get One Free
 */
public class BogofDiscount implements ActiveDiscount{

    private final IndividualProduct product;

    public BogofDiscount(IndividualProduct product) {
        this.product = product;
    }

    @Override
    public List<Discount> discountFor(List<Item> itemList) {
        long validItems = itemList.stream()
                .filter(i -> product.sku().equals(i.sku()))
                .count();

        int howManyDiscounts = (int) (validItems / 2);

        if(howManyDiscounts == 0) {
            return Collections.emptyList();
        }

        Discount discount = new Discount("Buy One, Get One Free: " + product.sku(),product.pricePerUnit().negate());
        return IntStream.rangeClosed(0, howManyDiscounts - 1)
                .mapToObj(i -> discount)
                .toList();
    }
}
