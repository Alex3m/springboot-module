package academy.everyonecodes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String wizardUrl;

    public Dorothy(RestTemplate restTemplate,
                   @Value("${urls.wizardurl}") String wizardUrl) {
        this.restTemplate = restTemplate;
        this.wizardUrl = wizardUrl;
    }

    public String homeAnswer() {
        String homeUrl = restTemplate.getForObject(wizardUrl, String.class);
        String homeName = restTemplate.getForObject(homeUrl, String.class);

        return "My home is " + homeName;
    }

}
