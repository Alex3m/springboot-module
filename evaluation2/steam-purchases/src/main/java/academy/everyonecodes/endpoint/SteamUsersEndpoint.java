package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.logic.SteamStoreService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SteamUsersEndpoint {
    private final SteamStoreService service;

    public SteamUsersEndpoint(SteamStoreService service) {
        this.service = service;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<SteamUser> getAll() {
        return service.getAllUsers();
    }
}
