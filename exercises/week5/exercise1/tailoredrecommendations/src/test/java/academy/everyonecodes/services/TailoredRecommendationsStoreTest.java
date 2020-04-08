package academy.everyonecodes.services;

import academy.everyonecodes.data.Movie;
import academy.everyonecodes.data.TailoredRecommendation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TailoredRecommendationsStoreTest {
    @Autowired
    TailoredRecommendationsStore store;

    Set<Movie> expectedGet = Set.of(new Movie("title1", "synopsis1"));
    String userUuid = "user1";

    String userUuid3 = "user3";
    Movie moviePost = new Movie("title3", "synopsis3");
    TailoredRecommendation inputPost = new TailoredRecommendation(userUuid3, moviePost);
    Set<Movie> expectedPost = Set.of(moviePost);

    @Test
    void postRecommendation() {
        store.postRecommendation(inputPost);
        Set<Movie> result = store.getRecommendationsForUser(userUuid3);
        Assertions.assertEquals(expectedPost, result);
    }

    @Test
    void getRecommendationsForUser() {
        Set<Movie> result = store.getRecommendationsForUser(userUuid);
        Assertions.assertEquals(expectedGet, result);
    }
}