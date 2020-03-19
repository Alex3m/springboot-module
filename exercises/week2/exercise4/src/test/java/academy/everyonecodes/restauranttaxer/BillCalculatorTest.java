package academy.everyonecodes.restauranttaxer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BillCalculatorTest {
    @Autowired
    BillCalculator billCalculator;

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4.5, List.of(new RestaurantDish("potato soup", 1), new RestaurantDish("soda", 1.2))),
                Arguments.of(2.1, List.of(new RestaurantDish("potato soup", 1))),
                Arguments.of(0, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, List<RestaurantDish> input) {
        double result = billCalculator.calculate(input);
        assertEquals(expected, result);
    }

}