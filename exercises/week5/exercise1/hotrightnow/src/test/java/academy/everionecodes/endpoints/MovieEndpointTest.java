package academy.everionecodes.endpoints;

import academy.everionecodes.services.MovieStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashSet;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MovieEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    MovieStore movieStore;

    String url = "/movies";

    @Test
    void getMovies() {
        restTemplate.getForObject(url, String.class);
        Mockito.verify(movieStore).getMovies();
    }
}