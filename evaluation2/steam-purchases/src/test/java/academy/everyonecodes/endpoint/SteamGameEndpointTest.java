package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.SteamGame;
import academy.everyonecodes.logic.SteamStoreService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SteamGameEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    SteamStoreService steamStoreService;

    String url = "/games";
    @Test
    void getAll() {
        restTemplate.getForObject(url, SteamGame[].class);
        Mockito.verify(steamStoreService).getAllGames();
    }
}