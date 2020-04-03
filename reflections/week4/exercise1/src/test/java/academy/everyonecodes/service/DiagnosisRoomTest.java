package academy.everyonecodes.service;

import academy.everyonecodes.data.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosisRoomTest {
    @Autowired
    DiagnosisRoom diagnosisRoom;

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new Patient("01", "name1", "sneezing, nasal congestion", "allergy"),
                        new Patient("01", "name1", "sneezing, nasal congestion", null)),
                Arguments.of(new Patient("02", "name2", "black eye", "Lupus"),
                        new Patient("02", "name2", "black eye", null))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void diagnose(Patient expected, Patient input) {
        Patient result = diagnosisRoom.diagnose(input);

        Assertions.assertEquals(expected, result);
    }
}