package academy.everyonecodes.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;

@Controller
public class MockyTextClient {
    private final RestTemplate restTemplate;
    private final String textUrl;
    private final String arrayUrl;

    public MockyTextClient(RestTemplate restTemplate,
                           @Value("${mocky.urls.text}") String textUrl,
                           @Value("${mocky.urls.array}") String arrayUrl) {
        this.restTemplate = restTemplate;
        this.textUrl = textUrl;
        this.arrayUrl = arrayUrl;
    }
    public String getText(){
        return restTemplate.getForObject(textUrl, String.class);
    }
    public String[] getArray() {
        return restTemplate.getForObject(arrayUrl, String[].class);
    }
}
