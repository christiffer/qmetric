package kata.supermarket;

import kata.supermarket.Item;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Discount implements Item {
    private final String sku;
    private final BigDecimal price;
    @Override
    public BigDecimal price() {
        return price;
    }

    @Override
    public String sku() {
        return sku;
    }
}
