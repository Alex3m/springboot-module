package academy.everyonecodes.calculator.calculator1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorTest {
    @Autowired
    Calculator calculator;


    @ParameterizedTest
    @CsvSource({
            "2, '1 + 1'",
            "0, '1 - 1'",
            "4, '2 * 2'",
            "1, '2 / 2'"
    })
    void calculate(double expected, String input) {
        double result = calculator.calculate(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculateThrowsException() {
        String input = "2 & 2";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(input);
        });
    }
}