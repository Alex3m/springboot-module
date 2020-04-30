package academy.everyonecodes.clients;

import academy.everyonecodes.data.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Controller
public class TailoredRecommendationsClient {
    private final RestTemplate restTemplate;
    private String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate,
                                         @Value("${recommendations.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Set<Movie> getMovies(String user) {
        return restTemplate.getForObject(url + "/" + user, Set.class);
    }
}
