package kata.supermarket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class DiscountServiceTest {

    DiscountService discountService;

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.arguments(Collections.emptySet(), Collections.emptyList(), Collections.emptyList()),
                Arguments.arguments(Collections.singleton(bogofMilk()), Collections.emptyList(), Collections.emptyList()),

                Arguments.arguments(Collections.singleton(bogofMilk()),
                        List.of(BasketUtils.aPintOfMilk(), BasketUtils.aPintOfMilk()), List.of(bogofMilkDiscount()))
        );
    }

    static ActiveDiscount bogofMilk() {
        return new BogofDiscount(BasketUtils.productPintOfMilk());
    }

    static Discount bogofMilkDiscount() {
        return new Discount("Buy One, Get One Free: " + BasketUtils.aPintOfMilk().sku(),
                BasketUtils.productPintOfMilk().pricePerUnit().negate());
    }

    @BeforeEach
    void setup() {
        discountService = new DiscountService();
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void shouldApplyCorrectDiscounts(Set<ActiveDiscount> activeDiscounts, List<Item> basketContent, List<Discount> expected) {
        activeDiscounts.forEach(discountService::addDiscount);

        List<Discount> actual = discountService.discountsFor(basketContent);

        Assertions.assertThat(actual).isEqualTo(expected);
    }


}