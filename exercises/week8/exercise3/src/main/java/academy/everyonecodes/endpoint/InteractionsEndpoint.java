package academy.everyonecodes.endpoint;

import academy.everyonecodes.coordinator.Coordinator;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interactions")
public class InteractionsEndpoint {
    private final Coordinator coordinator;

    public InteractionsEndpoint(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping()
    Integer getInteractionsCount() {
        return coordinator.getInteractionsCount();
    }
}
