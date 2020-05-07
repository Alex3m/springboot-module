package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.SteamGame;
import academy.everyonecodes.logic.SteamStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class SteamGameEndpoint {
    private final SteamStoreService service;

    public SteamGameEndpoint(SteamStoreService service) {
        this.service = service;
    }

    @GetMapping
    List<SteamGame> getAll() {
        return service.getAllGames();
    }
}
