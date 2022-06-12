package kata.supermarket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BogofDiscountTest {

    @ParameterizedTest
    @CsvSource({
            "0,0", "1,0","2,1","3,1"
    })
    void shouldCreateDiscountForList(int howManyItems, int expectedDiscounts){
        List<Item> items = IntStream.range(0,howManyItems).mapToObj(i -> BasketUtils.aPintOfMilk()).toList();
        List<Discount> actual = BasketUtils.bogofMilk().discountFor(items);

        Assertions.assertThat(actual).hasSize(expectedDiscounts);
    }

}