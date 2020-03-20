package academy.everyonecodes.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceToHandshakesTranslatorTest {
    @Autowired
    PriceToHandshakesTranslator translator;

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(), 2),
                Arguments.of(List.of(), 10),
                Arguments.of(List.of(), 10000),
                Arguments.of(List.of(), 10003),
                Arguments.of(List.of("thumb touches back"), 12),
                Arguments.of(List.of("little finger grab"), 13),
                Arguments.of(List.of("thumb touches back", "little finger grab"), 23),
                Arguments.of(List.of("little finger grab", "thumb touches back"), 32),
                Arguments.of(List.of("thumb touches back", "little finger grab", "thumb touches back", "little finger grab"), 2323)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(List<String> expected, int input) {
        List<String> result = translator.translate(input);
        assertEquals(expected, result);

    }
}