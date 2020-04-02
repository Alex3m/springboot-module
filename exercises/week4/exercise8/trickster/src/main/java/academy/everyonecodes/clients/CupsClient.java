package academy.everyonecodes.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class CupsClient {
    private final RestTemplate restTemplate;
    private final String url;

    public CupsClient(RestTemplate restTemplate,
                      @Value("${cup.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Boolean isTheCoinInside(int cupNumber) {
        return restTemplate.getForObject(url + "/" + cupNumber, Boolean.class);
    }
}
