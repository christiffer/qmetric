package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct implements Product {

    private final BigDecimal pricePerKilo;
    private final String sku;

    public WeighedProduct(final String sku, final BigDecimal pricePerKilo) {
        this.sku = sku;
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    @Override
    public String sku() {
        return sku;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }
}
