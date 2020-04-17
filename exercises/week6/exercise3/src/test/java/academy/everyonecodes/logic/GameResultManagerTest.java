package academy.everyonecodes.logic;

import academy.everyonecodes.data.GameResult;
import academy.everyonecodes.repository.GameResultRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class GameResultManagerTest {
    @Autowired
    GameResultManager manager;

    @MockBean
    ApplicationRunner gameRunner;

    @MockBean
    GameResultRepository repository;
    String input1 = "test1";
    GameResult mockResult1 = new GameResult(input1);

    private static Stream<Arguments> parameters() {
        GameResult mockResult1 = new GameResult("test1");
        GameResult mockResult2 = new GameResult("test2");
        return Stream.of(
                Arguments.of("test1: 1, test2: 1", new ArrayList<>(List.of(mockResult1, mockResult2))),
                Arguments.of("test1: 2, test2: 1", new ArrayList<>(List.of(mockResult1, mockResult1, mockResult2)))
        );
    }

    @Test
    void saveResult() {
        GameResult result = manager.saveResult(input1);
        verify(repository).save(result);
        Assertions.assertEquals(mockResult1, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void displayStatistics(String expected, List<GameResult> mockInput) {
        when(repository.findAll())
                .thenReturn(mockInput);
        String result = manager.displayStatistics();
        verify(repository).findAll();
        Assertions.assertEquals(expected, result);

    }
}