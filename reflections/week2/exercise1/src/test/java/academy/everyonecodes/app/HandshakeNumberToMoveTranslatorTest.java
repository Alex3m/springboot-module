package academy.everyonecodes.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {
    @Autowired
    HandshakeNumberToMoveTranslator translator;

    @ParameterizedTest
    @CsvSource({
            "'', 1",
            "'', 10",
            "thumb touches back, 2",
            "little finger grab, 3",

    })
    void translate(String expected, int input) {
        String result = translator.translate(input);
        assertEquals(expected, result);
    }
}