package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.data.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BasketTest {
    Basket basket = new Basket();

    private static Stream<Arguments> parameters() {
        Summary summaryOne = new Summary("emailOne", "testOne", 1.0, 2.0, 3.0);
        Summary summaryTwo = new Summary("emailTwo", "testTwo", 1.0, 2.0, 3.0);
        return Stream.of(
                Arguments.of(List.of(summaryOne, summaryTwo), summaryOne, summaryTwo)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void addAndGetMultipleSummary(List<Summary> expected, Summary inputOne, Summary inputTwo) {
        basket.addSummary(inputOne);
        basket.addSummary(inputTwo);
        List<Summary> result = basket.getSummaries();
        Assertions.assertEquals(expected, result);
    }
}