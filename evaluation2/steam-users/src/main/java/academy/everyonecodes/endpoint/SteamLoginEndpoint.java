package academy.everyonecodes.endpoint;

import academy.everyonecodes.logic.SteamUserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SteamLoginEndpoint {
    private final SteamUserService service;

    public SteamLoginEndpoint(SteamUserService service) {
        this.service = service;
    }

    @PostMapping
    public String post() {
        return service.getLoginMessage();
    }
}
