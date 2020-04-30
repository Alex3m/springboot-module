package academy.everyonecodes.endpoint;

import academy.everyonecodes.client.PoloClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    PoloClient client;
    String url = "/marco";
    String message = "marco";

    @Test
    void get() {
        String answer = restTemplate.getForObject(url + "/" + message, String.class);
        verify(client).get(message);
    }
}