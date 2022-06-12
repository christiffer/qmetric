package kata.supermarket;

import java.math.BigDecimal;

public class IndividualProduct implements Product {

    private final BigDecimal pricePerUnit;
    private final String sku;

    public IndividualProduct(String sku, final BigDecimal pricePerUnit) {
        this.sku=sku;
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    @Override
    public String sku() {
        return sku;
    }
}
