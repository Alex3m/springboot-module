package academy.everyonecodes.logic;

import academy.everyonecodes.data.GameResult;
import academy.everyonecodes.repository.GameResultRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameResultManager {
    private final GameResultRepository resultRepository;

    public GameResultManager(GameResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public GameResult saveResult(String winner) {
        GameResult gameResult = new GameResult(winner);
        resultRepository.save(gameResult);
        return gameResult;
    }

    public String displayStatistics() {
        List<GameResult> gameResults = resultRepository.findAll();
        Map<String, Long> statistics = winsCounter(gameResults);
        String currentStatistic = statistics.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .sorted(String::compareTo)
                .collect(Collectors.joining(", "));

        System.out.println("Game statistics: " + currentStatistic);
        return currentStatistic;
    }

    private Map<String, Long> winsCounter(List<GameResult> gameResults) {
        Map<String, Long> statistics = new HashMap<>();
        while (gameResults.size() > 0) {
            String winner = gameResults.get(0).getResult();
            long timesWon = gameResults.stream()
                    .filter(gameResult -> gameResult.getResult().equals(winner))
                    .count();
            statistics.put(winner, timesWon);

            gameResults.removeIf(
                    gameResult -> gameResult.getResult().equals(winner));
        }
        return statistics;
    }
}