package academy.everyonecodes.endpoints;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uppercase")
public class UppercaseEndpoint {

    @PostMapping
    String postString(@RequestBody String text){
        return text.toUpperCase();
    }
}
