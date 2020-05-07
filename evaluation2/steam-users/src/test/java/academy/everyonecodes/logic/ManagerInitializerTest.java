package academy.everyonecodes.logic;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repository.SteamUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ManagerInitializerTest {

    @Autowired
    ManagerInitializer initializer;

    @MockBean
    SteamUserRepository repository;

    @MockBean
    PasswordEncoder encoder;

    @MockBean
    ApplicationRunner initialize;

    String[] authorities = {"testRole"};
    SteamUser manager = new SteamUser("test", "test", authorities);

    @Test
    void firstInitialize() {
        when(repository.existsByUsername(manager.getUsername()))
                .thenReturn(false);
        when(encoder.encode(manager.getPassword()))
                .thenReturn(manager.getPassword());
        initializer.initialize();
        verify(repository).existsByUsername(manager.getUsername());
        verify(encoder).encode(manager.getPassword());
        verify(repository).save(manager);
    }

    @Test
    void initializeAfterTheFirst() {
        when(repository.existsByUsername(manager.getUsername()))
                .thenReturn(true);
        initializer.initialize();
        verify(repository).existsByUsername(manager.getUsername());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(encoder);
    }
}