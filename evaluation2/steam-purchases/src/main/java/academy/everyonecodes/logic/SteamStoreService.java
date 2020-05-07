package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Purchase;
import academy.everyonecodes.domain.SteamGame;
import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repositories.SteamGameRepository;
import academy.everyonecodes.repositories.SteamUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SteamStoreService {
    private final SteamGameRepository gameRepository;
    private final SteamUserRepository userRepository;
    private final PurchaseVerifier verifier;

    public SteamStoreService(SteamGameRepository gameRepository, SteamUserRepository userRepository, PurchaseVerifier verifier) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.verifier = verifier;
    }

    public Purchase processPurchase(Purchase purchase) {
        SteamUser user = verifier.verifyUser(purchase);
        SteamGame game = verifier.verifyGame(purchase);
        user.getSteamGames().add(game);
        userRepository.save(user);
        return purchase;
    }

    public List<SteamUser> getAllUsers() {
        return userRepository.findAll();
    }

    public List<SteamGame> getAllGames() {
        return gameRepository.findAll();
    }


}
