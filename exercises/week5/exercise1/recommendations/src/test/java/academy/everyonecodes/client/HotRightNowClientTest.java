package academy.everyonecodes.clients;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class HotRightNowClientTest {
    @Autowired
    HotRightNowClient client;
    @MockBean
    RestTemplate restTemplate;

    @Value("${hotrightnow.url}")
    String url;

    @Test
    void getHotMovies() {
        client.getHotMovies();
        Mockito.verify(restTemplate).getForObject(url, Set.class);
    }
}