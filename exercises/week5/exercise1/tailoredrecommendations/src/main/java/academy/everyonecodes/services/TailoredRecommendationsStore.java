package academy.everyonecodes.services;

import academy.everyonecodes.data.Movie;
import academy.everyonecodes.data.TailoredRecommendation;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TailoredRecommendationsStore {
    private Set<TailoredRecommendation> recommendations;

    public TailoredRecommendationsStore(Set<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public Set<Movie> getRecommendationsForUser(String userUuid) {
        return recommendations.stream()
                .filter(recommendation -> recommendation.getUserUuid().equals(userUuid))
                .map(TailoredRecommendation::getMovie)
                .collect(Collectors.toSet());
    }

    public TailoredRecommendation postRecommendation(TailoredRecommendation recommendation) {
        System.out.println(recommendation.getUserUuid());
        recommendations.add(recommendation);
        return recommendation;
    }
}
