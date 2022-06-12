package kata.supermarket;

import java.util.List;

/**
 * A discount active in the Supermarket
 */
public interface ActiveDiscount {
    List<Discount> discountFor(List<Item> itemList);
}
