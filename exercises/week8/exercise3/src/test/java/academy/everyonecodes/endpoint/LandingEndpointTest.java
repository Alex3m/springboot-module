package academy.everyonecodes.endpoint;

import academy.everyonecodes.coordinator.Coordinator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class LandingEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    Coordinator coordinator;
    String url = "/";

    @Test
    void getInteractionsCount() {
        restTemplate.getForObject(url, String.class);
        verify(coordinator).getLandingPageMessage();
    }
}