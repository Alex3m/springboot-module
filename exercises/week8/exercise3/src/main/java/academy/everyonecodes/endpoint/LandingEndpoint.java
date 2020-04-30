package academy.everyonecodes.endpoint;

import academy.everyonecodes.coordinator.Coordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LandingEndpoint {
    private final Coordinator coordinator;

    public LandingEndpoint(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    @GetMapping
    String getLandingPage() {
        return coordinator.getLandingPageMessage();
    }
}
