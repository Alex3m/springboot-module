package academy.everyonecodes.clients;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PoloClientTest {
    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${polo.url}")
    String url;

    String call = "Marco";
    String answer = "polo";

    @Test
    void get() {
        Mockito.when(restTemplate.getForObject(url, String.class))
                .thenReturn(answer);
        poloClient.get(call);

        Mockito.verify(restTemplate).postForObject(url, call, String.class);
    }
}