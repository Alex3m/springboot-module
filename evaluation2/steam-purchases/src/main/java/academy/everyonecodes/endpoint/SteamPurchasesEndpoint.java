package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.Purchase;
import academy.everyonecodes.logic.SteamStoreService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class SteamPurchasesEndpoint {
    private final SteamStoreService steamStoreService;

    public SteamPurchasesEndpoint(SteamStoreService steamStoreService) {
        this.steamStoreService = steamStoreService;
    }

    @PostMapping
    @Secured("ROLE_APP")
    Purchase post(@RequestBody Purchase purchase) {
        return steamStoreService.processPurchase(purchase);
    }
}
