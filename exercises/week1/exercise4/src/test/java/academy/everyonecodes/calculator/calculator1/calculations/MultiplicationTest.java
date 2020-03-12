package academy.everyonecodes.calculator.calculator1.calculations;

import academy.everyonecodes.calculator.calculator1.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class MultiplicationTest {
    @Autowired
    Multiplication multiplication;

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, Expression input) {
        double result = multiplication.calculate(input);
        Assertions.assertEquals(expected, result);
    }
    private static Stream parameters(){
        return Stream.of(
                Arguments.of(
                        1, new Expression("*", 1, 1 )
                ),
                Arguments.of(
                        1, new Expression("*", -1, -1 )
                ),
                Arguments.of(
                        4.5, new Expression("*", 3, 1.5 )
                )
        );
    }
}