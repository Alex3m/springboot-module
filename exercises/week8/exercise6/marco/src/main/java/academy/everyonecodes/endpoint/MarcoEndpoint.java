package academy.everyonecodes.endpoint;

import academy.everyonecodes.client.PoloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marco")
public class MarcoEndpoint {
    private final PoloClient client;

    public MarcoEndpoint(PoloClient client) {
        this.client = client;
    }

    @GetMapping("/{message}")
    String get(@PathVariable String message) {
        String answer = client.get(message);
        return answer;
    }
}
