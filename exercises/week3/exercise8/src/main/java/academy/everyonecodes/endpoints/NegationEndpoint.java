package academy.everyonecodes.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/negation")
public class NegationEndpoint {

    @PostMapping
    boolean postNegation(@RequestBody boolean isIt) {
        return !isIt;
    }
}
