package academy.everyonecodes.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasures")
public class SesameEndpoint {

    @GetMapping
    String get() {
        return "One Thousand and One Nights";
    }
}
