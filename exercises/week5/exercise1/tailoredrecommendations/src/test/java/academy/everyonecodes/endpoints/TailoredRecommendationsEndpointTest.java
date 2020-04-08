package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Movie;
import academy.everyonecodes.data.TailoredRecommendation;
import academy.everyonecodes.services.TailoredRecommendationsStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TailoredRecommendationsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TailoredRecommendationsStore store;

    String url = "/tailoredrecommendations";
    String userUuid = "user";

    TailoredRecommendation recommendation = new TailoredRecommendation(userUuid, new Movie("title", "synopsis"));

    @Test
    void get() {
        String userUuid = "user";

        restTemplate.getForObject(url + "/" + userUuid, List.class);
        verify(store).getRecommendationsForUser(userUuid);

    }

    @Test
    void post() {

        restTemplate.postForObject(url, recommendation, TailoredRecommendation.class);
        verify(store).postRecommendation(recommendation);
    }
}