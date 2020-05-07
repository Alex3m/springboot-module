package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Purchase;
import academy.everyonecodes.domain.SteamGame;
import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repositories.SteamGameRepository;
import academy.everyonecodes.repositories.SteamUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseVerifier {
    private final SteamUserRepository userRepository;
    private final SteamGameRepository gameRepository;

    public PurchaseVerifier(SteamUserRepository userRepository, SteamGameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public SteamGame verifyGame(Purchase purchase) {
        Optional<SteamGame> oGame = gameRepository.findOneByGameID(purchase.getGameID());
        return oGame.orElseGet(
                () -> gameRepository.save(new SteamGame(
                        purchase.getGameID(),
                        purchase.getGameName(),
                        purchase.getGamePrice())));
    }

    public SteamUser verifyUser(Purchase purchase) {
        String username = purchase.getUsername();
        Optional<SteamUser> oUser = userRepository.findOneByUsername(username);
        return oUser.orElseGet(
                () -> userRepository.save(new SteamUser(username)));
    }
}
