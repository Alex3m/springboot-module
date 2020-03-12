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
class DivisionTest {
    @Autowired
    Division division;

    private static Stream parameters() {
        return Stream.of(
                Arguments.of(
                        1, new Expression("/", 1, 1)
                ),
                Arguments.of(
                        1, new Expression("/", -1, -1)
                ),
                Arguments.of(
                        2, new Expression("/", 3, 1.5)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = division.calculate(input);
        assertEquals(expected, result);
    }
}