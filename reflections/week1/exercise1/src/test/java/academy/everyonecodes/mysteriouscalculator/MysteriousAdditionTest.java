package academy.everyonecodes.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousAdditionTest {
    MysteriousAddition mysteriousAddition = new MysteriousAddition(2);

    @ParameterizedTest
    @CsvSource({
            "4, 2",
            "0, -2",
            "2, 0"
    })
    void apply(int expected, int input) {
        int result = mysteriousAddition.apply(input);
        assertEquals(expected, result);
    }
}