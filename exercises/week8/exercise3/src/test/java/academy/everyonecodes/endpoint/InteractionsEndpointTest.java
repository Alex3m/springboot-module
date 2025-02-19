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
class InteractionsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    Coordinator coordinator;
    String url = "/interactions";

    @Test
    void getInteractionsCount() {
        restTemplate
                .withBasicAuth("admin", "admin")
                .getForObject(url, Integer.class);
        verify(coordinator).getInteractionsCount();
    }
}