package academy.everyonecodes.endpoints;

import academy.everyonecodes.services.HomeNameProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {
    private final HomeNameProvider homeNameProvider;

    public HomeEndpoint(HomeNameProvider homeNameProvider) {
        this.homeNameProvider = homeNameProvider;
    }

    @GetMapping
    String getHomeName() {
        return homeNameProvider.getHomeName();
    }
}
