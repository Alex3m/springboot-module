package academy.everyonecodes.clients;

import academy.everyonecodes.data.Runner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MarathonClient {
    private final RestTemplate restTemplate;
    private final String winnerUrl;
    private final String postrunnerUrl;

    public MarathonClient(RestTemplate restTemplate,
                          @Value("${marathon.winnerurl}") String winnerUrl,
                          @Value("${marathon.postrunnerurl}") String postrunnerUrl) {
        this.restTemplate = restTemplate;
        this.winnerUrl = winnerUrl;
        this.postrunnerUrl = postrunnerUrl;
    }

    public Runner postRunner(Runner runner) {
        return restTemplate.postForObject(postrunnerUrl, runner, Runner.class);

    }

    public Runner getWinner() {
        return restTemplate.getForObject(winnerUrl, Runner.class);
    }
}
