package academy.everyonecodes.endpoints;

import academy.everyonecodes.services.Polo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Polo polo;

    String url = "/polo";
    String call = "Marco";

    @Test
    void post() {
        restTemplate.postForObject(url, call, String.class);
        Mockito.verify(polo).answering(call);
    }
}