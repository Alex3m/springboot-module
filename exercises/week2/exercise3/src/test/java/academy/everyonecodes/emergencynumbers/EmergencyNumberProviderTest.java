package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmergencyNumberProviderTest {
    @Autowired
    EmergencyNumberProvider emergencyNumberProvider;

    @ParameterizedTest
    @CsvSource({
            "133, police",
            "122, fire brigade",
            "112, Four",
            "112, general emergency"

    })
    void provide(int expected, String input) {
        int result = emergencyNumberProvider.provide(input);
        assertEquals(expected, result);

    }
}