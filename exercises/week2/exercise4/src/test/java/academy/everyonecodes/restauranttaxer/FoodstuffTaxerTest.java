package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodstuffTaxerTest {
    @Autowired
    FoodstuffTaxer foodstuffTaxer;

    private static Stream<Arguments> parametersForMatches() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("potato soup", 5)),
                Arguments.of(false, new RestaurantDish("soda", 5))
        );
    }

    private static Stream<Arguments> parametersForTax() {
        return Stream.of(
                Arguments.of(6.1, new RestaurantDish("potato soup", 5)),
                Arguments.of(1.1, new RestaurantDish("tiramisu", 0))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersForMatches")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = foodstuffTaxer.matches(input);
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("parametersForTax")
    void tax(double expected, RestaurantDish input) {
        double result = foodstuffTaxer.tax(input);
        assertEquals(expected, result);
    }

}