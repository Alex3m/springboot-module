package academy.everyonecodes.calculator.calculator1.calculations;

import academy.everyonecodes.calculator.calculator1.Expression;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubtractionTest {
    @Autowired
    Subtraction subtraction;

    private static Stream parameters() {
        return Stream.of(
                Arguments.of(
                        0, new Expression("-", 1, 1)
                ),
                Arguments.of(
                        2, new Expression("-", 1, -1)
                ),
                Arguments.of(
                        0.5, new Expression("-", 1.5, 1)
                )
        );
    }
    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = subtraction.calculate(input);
        assertEquals(expected, result);
    }
}