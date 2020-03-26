package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.CommunityEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CommunityEventEndpoint {
    private List<CommunityEvent> events;

    public CommunityEventEndpoint(List<CommunityEvent> events) {
        this.events = events;
    }

    @GetMapping
    List<CommunityEvent> get() {
        return events;
    }
}
