package academy.everyonecodes.services;

import academy.everyonecodes.clients.HotRightNowClient;
import academy.everyonecodes.clients.TailoredRecommendationsClient;
import academy.everyonecodes.data.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Set;
import java.util.stream.Stream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class RecommendationServiceTest {
    @Autowired
    RecommendationService service;

    @MockBean
    TailoredRecommendationsClient recommendationsClient;
    @MockBean
    HotRightNowClient hotRightNowClient;

    String userUuid = "test user";

    private static Stream<Arguments> parameters() {
        Movie hotMovie = new Movie("hotTest", "hotSynopsis");
        Movie recommendedMovie = new Movie("recommendedTest", "recommendedSynopsis");
        return Stream.of(
                Arguments.of(Set.of(recommendedMovie), Set.of(recommendedMovie), Set.of(hotMovie)),
                Arguments.of(Set.of(hotMovie), Set.of(), Set.of(hotMovie))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void recommend(Set<Movie> expected, Set<Movie> recommendedMovieInput, Set<Movie> hotMovieInput) {
        Mockito.when(recommendationsClient.getMovies(userUuid))
                .thenReturn(recommendedMovieInput);
        Mockito.when(hotRightNowClient.getHotMovies())
                .thenReturn(hotMovieInput);
        Set<Movie> result = service.recommend(userUuid);

        Assertions.assertEquals(expected, result);
    }
}