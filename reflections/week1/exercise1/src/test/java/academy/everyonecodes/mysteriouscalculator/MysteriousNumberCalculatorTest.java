package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MysteriousNumberCalculatorTest {
    @Autowired
    MysteriousNumberCalculator mysteriousNumberCalculator;

    @ParameterizedTest
    @CsvSource({
            "The mysterious number is 5, 2",
            "The mysterious number is 6, 3",
            "The mysterious number is 3, 0"

    })
    void calculate(String expected, int input) {
        String result = mysteriousNumberCalculator.calculate(input);

        Assertions.assertEquals(expected, result);
    }
}