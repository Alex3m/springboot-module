package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.TestResult;
import academy.everyonecodes.tester.MarathonTester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon/integration")
public class MarathonIntegrationEndpoint {
    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

    @GetMapping
    TestResult getTest() {
        return marathonTester.getTested();
    }
}
