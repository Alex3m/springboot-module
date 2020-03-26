package academy.everyonecodes.beans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypesEndpoint {

    @GetMapping("/text")
    String getText() {
        return "Types";
    }

    @GetMapping("/number")
    int getInt() {
        return 25920;
    }

    @GetMapping("/choice")
    boolean getChoice() {
        return false;
    }

}
