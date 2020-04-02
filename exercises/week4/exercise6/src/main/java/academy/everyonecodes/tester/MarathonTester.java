package academy.everyonecodes.tester;

import academy.everyonecodes.clients.MarathonClient;
import academy.everyonecodes.data.Runner;
import academy.everyonecodes.data.TestResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class MarathonTester {
    private final MarathonClient marathonClient;
    private final Runner winner;
    private final List<Runner> runners;

    public MarathonTester(MarathonClient marathonClient, Runner winner, List<Runner> runners) {
        this.marathonClient = marathonClient;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult getTested() {
        runners.forEach(marathonClient::postRunner);
        TestResult successfulTest = new TestResult("Success", "Tests run correctly");
        TestResult incorrectWinner = new TestResult("Error", "Incorrect winner received");
        TestResult noWinnerReceived = new TestResult("Error", "No winner should have been received in the first call");
        Runner winnerResult = marathonClient.getWinner();

        if (!winnerResult.equals(null)) {
            if (winnerResult.equals(winner)) {
                return successfulTest;
            }
            return incorrectWinner;
        }
        return noWinnerReceived;
    }
}