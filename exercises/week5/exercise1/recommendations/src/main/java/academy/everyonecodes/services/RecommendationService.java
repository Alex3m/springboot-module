package academy.everyonecodes.services;

import academy.everyonecodes.clients.HotRightNowClient;
import academy.everyonecodes.clients.TailoredRecommendationsClient;
import academy.everyonecodes.data.Movie;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecommendationService {
    private final TailoredRecommendationsClient recommendationsClient;
    private final HotRightNowClient hotRightNowClient;

    public RecommendationService(TailoredRecommendationsClient recommendationsClient, HotRightNowClient hotRightNowClient) {
        this.recommendationsClient = recommendationsClient;
        this.hotRightNowClient = hotRightNowClient;
    }

    public Set<Movie> recommend(String userUuid) {
        Set<Movie> recommendedMovies = recommendationsClient.getMovies(userUuid);
        if (recommendedMovies.isEmpty()) {
            recommendedMovies = hotRightNowClient.getHotMovies();
        }
        return recommendedMovies;
    }
}
