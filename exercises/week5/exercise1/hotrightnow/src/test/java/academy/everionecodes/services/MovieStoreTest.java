package academy.everionecodes.services;

import academy.everionecodes.data.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MovieStoreTest {
    @Autowired
    MovieStore movieStore;

    @Autowired
    Set<Movie> movies;

    @Test
    void getMovies() {
        Set<Movie> result = movieStore.getMovies();
        Assertions.assertEquals(movies, result);
    }
}