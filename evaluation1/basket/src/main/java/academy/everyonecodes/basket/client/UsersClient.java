package academy.everyonecodes.basket.client;

import academy.everyonecodes.basket.data.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersClient {
    private final RestTemplate restTemplate;
    private final String url;

    public UsersClient(RestTemplate restTemplate,
                       @Value("${userstore.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public User getUser(String email) {
        return restTemplate.getForObject(url + "/" + email, User.class);
    }
}
