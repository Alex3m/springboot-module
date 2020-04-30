package academy.everyonecodes.endpoint;

import academy.everyonecodes.coordinator.Coordinator;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/languages")
public class SchoolEndpoint {
    private final Coordinator coordinator;

    public SchoolEndpoint(Coordinator coordinator) {
        this.coordinator = coordinator;
    }


    @GetMapping
    @Secured("ROLE_USER")
    String getUserFirstEntry() {
        return coordinator.getUserFirstEntry();
    }

    @Secured("ROLE_GERMAN")
    @GetMapping("/german")
    String getGermanMessage() {
        return coordinator.getGerman();
    }

    @Secured("ROLE_ENGLISH")
    @GetMapping("/english")
    String getEnglishMessage() {
        return coordinator.getEnglish();
    }

}
