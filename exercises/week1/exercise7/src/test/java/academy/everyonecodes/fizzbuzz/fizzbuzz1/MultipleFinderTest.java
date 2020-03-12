package academy.everyonecodes.fizzbuzz.fizzbuzz1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleFinderTest {
    MultipleFinder multipleFinder = new MultipleFinder(3, "Fizz");

    @ParameterizedTest
    @CsvSource({
            "true, 3",
            "true, 6",
            "false, 4"
    })
    void isMultiple(boolean expected, int input) {
        boolean result = multipleFinder.isMultiple(input);
        assertEquals(expected, result);
    }
}