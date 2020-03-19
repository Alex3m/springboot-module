package academy.everyonecodes.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuhnTest {
    Luhn luhn = new Luhn();

    @ParameterizedTest
    @CsvSource({
            "true, 378282246310005",
            "false, 378282246310004",

    })
    void isValid(boolean expected, String input) {
        boolean result = luhn.isValid(input);
        assertEquals(expected, result);
    }
}