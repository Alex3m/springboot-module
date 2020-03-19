package academy.everyonecodes.game;

import academy.everyonecodes.game.moves.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JudgeTest {
    Judge judge = new Judge();

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("Nobody wins", new Move("rock", "scissors"), new Move("rock", "scissors")),
                Arguments.of("Player 1 wins", new Move("scissors", "paper"), new Move("paper", "rock")),
                Arguments.of("Player 2 wins", new Move("rock", "scissors"), new Move("paper", "rock"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move inputOne, Move inputTwo) {
        String result = judge.judge(inputOne, inputTwo);

        Assertions.assertEquals(expected, result);

    }

}