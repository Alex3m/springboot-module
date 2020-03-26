package academy.everyonecodes.beans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChoiceEndpoint {

    @GetMapping
    boolean get() {
        return true;
    }
}
