package academy.everyonecodes.endpoint;

import academy.everyonecodes.logic.Polo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    Polo polo;

    String url = "/polo";
    String message = "marco";
    String user = "marcopolo";
    String password = "marcopolo";

    @Test
    void post() {
        restTemplate.withBasicAuth(user, password)
                .postForObject(url, message, String.class);
        verify(polo).answer(message);
    }
}