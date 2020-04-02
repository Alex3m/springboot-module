package academy.everyonecodes.clients;

import academy.everyonecodes.data.Postcard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class MockyPostcardsClient {
    private RestTemplate restTemplate;
    private String urlPostCardOne;
    private List<String> urlPostcards;

    public MockyPostcardsClient(RestTemplate restTemplate,
                                @Value("${mocky.urls.postcard1}") String urlPostcardOne,
                                @Value("${mocky.urls.postcards}") List<String> urlPostcards) {
        this.restTemplate = restTemplate;
        this.urlPostCardOne = urlPostcardOne;
        this.urlPostcards = urlPostcards;
    }

    public Postcard getPostcard() {
        return restTemplate.getForObject(urlPostCardOne, Postcard.class);
    }

    public List<Postcard> getPostcardList() {
        return urlPostcards.stream()
                .map(e -> restTemplate.getForObject(e, Postcard.class))
                .collect(toList());
    }
}
