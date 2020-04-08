package academy.everionecodes.services;

import academy.everionecodes.data.Movie;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MovieStore {
    private final Set<Movie> movies;

    public MovieStore(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}