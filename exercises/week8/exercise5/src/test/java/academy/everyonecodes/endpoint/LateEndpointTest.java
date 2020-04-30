package academy.everyonecodes.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class LateEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Value("${content.message}")
    String message;
    String url = "/";

    @Test
    void getMessage() {
        restTemplate.getForObject(url, String.class);
    }
}