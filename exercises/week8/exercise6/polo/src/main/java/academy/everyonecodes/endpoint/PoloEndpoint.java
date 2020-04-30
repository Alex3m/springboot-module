package academy.everyonecodes.endpoint;

import academy.everyonecodes.logic.Polo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private final Polo polo;

    public PoloEndpoint(Polo polo) {
        this.polo = polo;
    }

    @PostMapping
    String post(@RequestBody String message) {
        return polo.answer(message);
    }
}
