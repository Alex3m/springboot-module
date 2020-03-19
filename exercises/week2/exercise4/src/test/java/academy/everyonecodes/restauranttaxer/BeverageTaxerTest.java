package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeverageTaxerTest {
    @Autowired
    BeverageTaxer beverageTaxer;

    private static Stream<Arguments> parametersForMatches() {
        return Stream.of(
                Arguments.of(true, new RestaurantDish("soda", 5)),
                Arguments.of(false, new RestaurantDish("potato soup", 5))
        );
    }

    private static Stream<Arguments> parametersForTax() {
        return Stream.of(
                Arguments.of(6.2, new RestaurantDish("soda", 5)),
                Arguments.of(1.2, new RestaurantDish("milkshake", 0))
        );
    }

    @ParameterizedTest
    @MethodSource("parametersForMatches")
    void matches(boolean expected, RestaurantDish input) {
        boolean result = beverageTaxer.matches(input);
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("parametersForTax")
    void tax(double expected, RestaurantDish input) {
        double result = beverageTaxer.tax(input);
        assertEquals(expected, result);
    }

}

