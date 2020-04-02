package academy.everyonecodes.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoremIpsumClient {
    private RestTemplate restTemplate;
    private final String url = "https://loripsum.net/api";

    public LoremIpsumClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String getText(){
        return restTemplate.getForObject(url, String.class);
    }
}
