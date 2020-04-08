package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Movie;
import academy.everyonecodes.data.TailoredRecommendation;
import academy.everyonecodes.services.TailoredRecommendationsStore;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/tailoredrecommendations")
public class TailoredRecommendationsEndpoint {
    private TailoredRecommendationsStore store;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore store) {
        this.store = store;
    }

    @GetMapping("/{userUuid}")
    Set<Movie> get(@PathVariable String userUuid) {
        return store.getRecommendationsForUser(userUuid);
    }

    @PostMapping
    TailoredRecommendation post(@RequestBody TailoredRecommendation recommendation) {
        return store.postRecommendation(recommendation);
    }
}
