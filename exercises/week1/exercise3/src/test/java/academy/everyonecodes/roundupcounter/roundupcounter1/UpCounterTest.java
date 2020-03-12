package academy.everyonecodes.roundupcounter.roundupcounter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UpCounterTest {
    @Autowired
    UpCounter upCounter;

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, List.of(1.0, 1.1, 1.5, 1.6)),
                Arguments.of(1, List.of(1.6)),
                Arguments.of(0, List.of(1.0)),
                Arguments.of(0, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void count(long expected, List<Double> input) {
        long result = upCounter.count(input);

        assertEquals(expected, result);
    }
}