package academy.everionecodes.endpoints;

import academy.everionecodes.data.Movie;
import academy.everionecodes.services.MovieStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieEndpoint {
    private final MovieStore movieStore;

    public MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    @GetMapping
    Set<Movie> getMovies() {
        return movieStore.getMovies();
    }
}
