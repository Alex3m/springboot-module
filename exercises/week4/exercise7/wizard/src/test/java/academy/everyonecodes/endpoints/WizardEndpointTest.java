package academy.everyonecodes.endpoints;

import academy.everyonecodes.services.HomeURLProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WizardEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    HomeURLProvider urlProvider;

    String url = "/wizard";

    @Test
    void getURL() {
        restTemplate.getForObject(url, String.class);
        Mockito.verify(urlProvider).getHomeURL();
    }
}