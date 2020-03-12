package academy.everyonecodes.roundupcounter.roundupcounter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "SAME, 1",
            "SAME, 1.5",
            "UP, 1.6",
            "DOWN, 1.1"
    })
    void indicate(String expected, double input) {
        String result = upDownIndicator.indicate(input);
        assertEquals(expected, result);
    }
}