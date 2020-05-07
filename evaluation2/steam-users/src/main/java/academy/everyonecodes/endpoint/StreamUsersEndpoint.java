package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.logic.SteamUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class StreamUsersEndpoint {
    private final SteamUserService steamUserService;

    public StreamUsersEndpoint(SteamUserService steamUserService) {
        this.steamUserService = steamUserService;
    }

    @PostMapping
    SteamUser post(@RequestBody SteamUser steamUser) {
        return steamUserService.saveUser(steamUser);
    }
}
