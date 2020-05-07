package academy.everyonecodes.logic;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repository.SteamUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SteamUserServiceTest {
    @Autowired
    SteamUserService steamUserService;

    @MockBean
    SteamUserRepository repository;
    @MockBean
    PasswordEncoder encoder;
    @MockBean
    ApplicationRunner applicationRunner;

    @Value("${steam.login-message.successful}")
    String expectedMessage;
    SteamUser steamUser = new SteamUser("test", "testPassword", null);

    @Test
    void noSaveExistingUser() {

        when(repository.findOneByUsername(steamUser.getUsername()))
                .thenReturn(Optional.of(steamUser));

        steamUserService.saveUser(steamUser);
        verify(repository).findOneByUsername(steamUser.getUsername());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void saveUser() {
        String[] authorities = {"ROLE_USER"};
        SteamUser expected = new SteamUser("test", "testPassword", authorities);

        when(repository.findOneByUsername(steamUser.getUsername()))
                .thenReturn(Optional.empty());
        when(encoder.encode(steamUser.getPassword()))
                .thenReturn(steamUser.getPassword());
        when(repository.save(steamUser))
                .thenReturn(steamUser);

        SteamUser result = steamUserService.saveUser(steamUser);

        verify(repository).findOneByUsername(steamUser.getUsername());
        verify(encoder).encode(steamUser.getPassword());
        verify(repository).save(steamUser);
        verifyNoMoreInteractions(repository);

        assertEquals(expected, result);
    }

    @Test
    void getLoginMessage() {
        String result = steamUserService.getLoginMessage();
        assertEquals(expectedMessage, result);
    }
}