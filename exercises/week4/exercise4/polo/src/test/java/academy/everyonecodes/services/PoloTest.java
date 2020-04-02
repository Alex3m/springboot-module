package academy.everyonecodes.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PoloTest {
    Polo polo = new Polo();

    @ParameterizedTest
    @CsvSource({
            "Polo, Marco",
            "What?, marco",
            "What?, Liugi"
    })
    void answering(String expected, String input) {
        String result = polo.answering(input);
        assertEquals(expected, result);
    }
}