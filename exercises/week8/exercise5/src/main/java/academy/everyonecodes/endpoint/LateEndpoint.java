package academy.everyonecodes.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LateEndpoint {
    private String message;

    public LateEndpoint(
            @Value("${content.message}") String message) {
        this.message = message;
    }

    @GetMapping
    String getMessage() {
        return message;
    }
}
