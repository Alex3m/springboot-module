package academy.everyonecodes.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {
    private final RestTemplate restTemplate;
    private final String url;

    public PoloClient(RestTemplate restTemplate,
                      @Value("${polo.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String get(String call) {
        return restTemplate.postForObject(url, call, String.class);
    }
}
