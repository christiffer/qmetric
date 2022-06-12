package kata.supermarket;

import org.junit.jupiter.params.provider.Arguments;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class BasketUtils {
    public static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    public static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    public static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    public static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    public static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    public static IndividualProduct productPintOfMilk() {
        return new IndividualProduct("milk", new BigDecimal("0.49"));
    }

    public static Item aPintOfMilk() {
        return productPintOfMilk().oneOf();
    }

    public static Item aPackOfDigestives() {
        return new IndividualProduct("digestives", new BigDecimal("1.55")).oneOf();
    }

    public static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct("us-sweets", new BigDecimal("4.99"));
    }

    public static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    public static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct("pick-and-mix", new BigDecimal("2.99"));
    }

    public static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }


    static ActiveDiscount bogofMilk() {
        return new BogofDiscount(BasketUtils.productPintOfMilk());
    }

    static Discount bogofMilkDiscount() {
        return new Discount("Buy One, Get One Free: " + BasketUtils.aPintOfMilk().sku(),
                BasketUtils.productPintOfMilk().pricePerUnit().negate());
    }
}
