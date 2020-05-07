package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Purchase;
import academy.everyonecodes.domain.SteamGame;
import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repositories.SteamGameRepository;
import academy.everyonecodes.repositories.SteamUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PurchaseVerifierTest {
    @Autowired
    PurchaseVerifier verifier;
    @MockBean
    SteamGameRepository gameRepository;
    @MockBean
    SteamUserRepository userRepository;

    Purchase purchase = new Purchase("testUser", "testID", "testGame", 5.5);
    SteamGame steamGame = new SteamGame("testID", "testGame", 5.5);
    SteamUser steamUser = new SteamUser(purchase.getUsername());

    @Test
    void verifyNewGame() {

        when(gameRepository.findOneByGameID(purchase.getGameID()))
                .thenReturn(Optional.empty());
        verifier.verifyGame(purchase);
        verify(gameRepository).findOneByGameID(purchase.getGameID());
        verify(gameRepository).save(steamGame);
    }

    @Test
    void verifyPreexistingGame() {

        when(gameRepository.findOneByGameID(purchase.getGameID()))
                .thenReturn(Optional.of(steamGame));
        verifier.verifyGame(purchase);
        verify(gameRepository).findOneByGameID(purchase.getGameID());
        verifyNoMoreInteractions(gameRepository);
    }


    @Test
    void verifyNewUser() {
        when(userRepository.findOneByUsername(purchase.getUsername()))
                .thenReturn(Optional.empty());
        verifier.verifyUser(purchase);
        verify(userRepository).findOneByUsername(purchase.getUsername());
        verify(userRepository).save(steamUser);
    }
    @Test
    void verifyPreexistingUser() {
        when(userRepository.findOneByUsername(purchase.getUsername()))
                .thenReturn(Optional.of(steamUser));
        verifier.verifyUser(purchase);
        verify(userRepository).findOneByUsername(purchase.getUsername());
        verifyNoMoreInteractions(userRepository);
    }
}