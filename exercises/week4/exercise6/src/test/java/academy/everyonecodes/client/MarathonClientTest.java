package academy.everyonecodes.clients;

import academy.everyonecodes.data.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MarathonClientTest {
    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${marathon.postrunnerurl}")
    String postURL;
    @Value("${marathon.winnerurl}")
    String winnerURL;
    Runner runner = new Runner("name", Duration.parse("PT1H1M1S"));


    @Test
    void postRunner() {
        when(restTemplate.postForObject(postURL, runner, Runner.class))
                .thenReturn(runner);
        marathonClient.postRunner(runner);
        verify(restTemplate).postForObject(postURL, runner, Runner.class);
    }

    @Test
    void getWinner() {
        when(restTemplate.getForObject(winnerURL, Runner.class))
                .thenReturn(runner);
        marathonClient.getWinner();
        verify(restTemplate).getForObject(winnerURL, Runner.class);
    }
}