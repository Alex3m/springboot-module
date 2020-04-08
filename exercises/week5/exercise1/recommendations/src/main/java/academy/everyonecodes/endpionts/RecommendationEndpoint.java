package academy.everyonecodes.endpionts;

import academy.everyonecodes.data.Movie;
import academy.everyonecodes.services.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {
    private final RecommendationService service;

    public RecommendationEndpoint(RecommendationService service) {
        this.service = service;
    }
    @GetMapping("/{userUuid}")
    Set<Movie> getMovies(@PathVariable String userUuid){
        return service.recommend(userUuid);
    }
}
