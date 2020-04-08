package academy.everionecodes.configuration;

import academy.everionecodes.data.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ConfigurationProperties("moviestore")
public class MovieConfiguration {
    private Set<Movie> movies;

    void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Bean
    public Set<Movie> movies() {
        return movies;
    }
}
