package academy.everyonecodes.endpoints;

import academy.everyonecodes.services.HomeURLProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {
    private final HomeURLProvider urlProvider;

    public WizardEndpoint(HomeURLProvider urlProvider) {
        this.urlProvider = urlProvider;
    }

    @GetMapping
    String getURL() {
        return urlProvider.getHomeURL();
    }
}
