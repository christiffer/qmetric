package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final IndividualProduct product;

    ItemByUnit(final IndividualProduct product) {
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    @Override
    public String sku() {
        return product.sku();
    }
}
