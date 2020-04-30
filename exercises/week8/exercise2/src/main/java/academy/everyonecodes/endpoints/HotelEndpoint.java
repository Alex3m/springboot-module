package academy.everyonecodes.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {
    @GetMapping
    String get() {
        return "Welcome to the hotel";
    }

    @GetMapping("/room")
    String getWithCredentials() {
        return "Welcome to your room";
    }
}
