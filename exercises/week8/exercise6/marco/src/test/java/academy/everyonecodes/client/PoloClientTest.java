package academy.everyonecodes.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PoloClientTest {
    @Autowired
    PoloClient client;
    @MockBean
    RestTemplate restTemplate;
    @Value("${polo.url}")
    String url;
    String call = "marco";

    @Test
    void get() {
        client.get(call);
        verify(restTemplate).postForObject(url, call, String.class);
    }
}