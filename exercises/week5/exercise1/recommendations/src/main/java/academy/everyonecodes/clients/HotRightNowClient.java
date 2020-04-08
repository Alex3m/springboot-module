package academy.everyonecodes.clients;

import academy.everyonecodes.data.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Controller
public class HotRightNowClient {
    private final RestTemplate restTemplate;
    private String url;

    public HotRightNowClient(RestTemplate restTemplate,
                             @Value("${hotrightnow.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Set<Movie> getHotMovies() {
        return restTemplate.getForObject(url, Set.class);
    }
}
