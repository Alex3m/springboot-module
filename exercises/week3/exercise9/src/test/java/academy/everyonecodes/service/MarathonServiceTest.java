package academy.everyonecodes.service;

import academy.everyonecodes.data.Runner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MarathonServiceTest {
    @Autowired
    MarathonService marathonService;

    @ParameterizedTest
    @MethodSource("parameters")
    void add(Set<Runner> expected, Runner input) {
        marathonService.add(input);
        Set<Runner> result = marathonService.getRunners();
        assertEquals(expected, result);
    }

    @Test
    void findWinner() {
        Runner input = new Runner("name2", Duration.parse("PT1H30M31S"));
        Runner expected = new Runner("name", Duration.parse("PT1H30M30S"));
        marathonService.add(input);
        Optional<Runner> oResult = marathonService.findWinner();
        assertTrue(oResult.isPresent());
        assertEquals(expected, oResult.get());
    }
    private static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(Set.of(new Runner("name", Duration.parse("PT1H30M30S"))), new Runner("name", Duration.parse("PT1H30M30S")))
        );
    }
}