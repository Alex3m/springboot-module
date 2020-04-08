package academy.everyonecodes.endpionts;

import academy.everyonecodes.services.RecommendationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Set;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    RecommendationService service;

    String url = "/recommendations";
    String userUuid = "testUuid";

    @Test
    void getMovies() {
        restTemplate.getForObject(url + "/" + userUuid, Set.class);
        Mockito.verify(service).recommend(userUuid);
    }
}