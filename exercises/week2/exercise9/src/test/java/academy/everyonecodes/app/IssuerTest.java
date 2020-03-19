package academy.everyonecodes.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

class IssuerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(true, new Issuer("American Express", Set.of("34", "37"), Set.of(15)), "345676553434545"),
                Arguments.of(true, new Issuer("Discover", Set.of("6011", "644", "645", "646", "647", "648", "649", "65"), Set.of(16, 19)), "6475676553434545"),
                Arguments.of(false, new Issuer("American Express", Set.of("51", "52", "53", "54", "55"), Set.of(16)), "3456765")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void issues(boolean expected, Issuer issuer, String input) {
        boolean result = issuer.issues(input);
        Assertions.assertEquals(expected, result);
    }
}