package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MysteriousNumberFormatterTest {
    @Autowired
    MysteriousNumberFormatter mysteriousNumberFormatter;

    @ParameterizedTest
    @CsvSource({
            "'The mysterious number is 0', 0",
            "'The mysterious number is 5', 5",
            "'The mysterious number is -5', -5",

    })
    void format(String expected, int input) {
        String result = mysteriousNumberFormatter.format(input);

        assertEquals(expected, result);
    }
}