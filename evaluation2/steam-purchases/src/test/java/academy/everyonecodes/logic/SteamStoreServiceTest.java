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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SteamStoreServiceTest {
    @Autowired
    SteamStoreService steamStoreService;
    @MockBean
    SteamUserRepository userRepository;
    @MockBean
    SteamGameRepository gameRepository;
    @MockBean
    PurchaseVerifier verifier;


    @Test
    void processPurchase() {
        Purchase purchase = new Purchase("testUser", "testID", "testGame", 5.5);
        SteamUser user = new SteamUser(purchase.getUsername());
        SteamGame game = new SteamGame(purchase.getGameID(), purchase.getGameName(), purchase.getGamePrice());
        SteamUser expectedUser = new SteamUser(purchase.getUsername(), Set.of(game));

        when(verifier.verifyUser(purchase))
                .thenReturn(user);
        when(verifier.verifyGame(purchase))
                .thenReturn(game);

        Purchase result = steamStoreService.processPurchase(purchase);
        verify(verifier).verifyUser(purchase);
        verify(verifier).verifyGame(purchase);
        verify(userRepository).save(user);
        assertEquals(expectedUser, user);
        assertEquals(purchase, result);

    }

    @Test
    void getAllUsers() {
        steamStoreService.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    void getAllGames() {
        steamStoreService.getAllGames();
        verify(gameRepository).findAll();
    }
}