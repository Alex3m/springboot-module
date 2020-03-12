package academy.everyonecodes.calculator.calculator1.calculations;

import academy.everyonecodes.calculator.calculator1.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AdditionTest {
    @Autowired
    Addition addition;
    @ParameterizedTest
    @MethodSource("parameters")

    void calculate(double expected, Expression input) {

        double result = addition.calculate(input);
        assertTrue(addition.matches(input));
        assertEquals(expected, result);
    }
    private static Stream parameters(){
        return Stream.of(
                Arguments.of(
                        2, new Expression("+", 1, 1 )
                ),
                Arguments.of(
                        0, new Expression("+", 1, -1 )
                ),
                Arguments.of(
                        2.5, new Expression("+", 1.5, 1 )
                )
        );
    }
}