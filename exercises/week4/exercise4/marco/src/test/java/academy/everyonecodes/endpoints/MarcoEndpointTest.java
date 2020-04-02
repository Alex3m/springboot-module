package academy.everyonecodes.endpoints;

import academy.everyonecodes.clients.PoloClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarcoEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    PoloClient poloClient;

    String answer = "polo";
    String call = "Marco";
    String url = "/marco/"+answer;

    @Test
    void get() {
        when(poloClient.get(call))
                .thenReturn(answer);
        restTemplate.getForObject(url, String.class);
        verify(poloClient).get(answer);
    }
}