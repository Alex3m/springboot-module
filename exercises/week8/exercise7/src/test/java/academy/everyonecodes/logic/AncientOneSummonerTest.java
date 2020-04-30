package academy.everyonecodes.logic;

import academy.everyonecodes.SummonerRunner;
import academy.everyonecodes.domain.Member;
import academy.everyonecodes.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AncientOneSummonerTest {
    @Autowired
    AncientOneSummoner summoner;

    @MockBean
    MemberRepository repository;
    @MockBean
    PasswordEncoder encoder;
    @MockBean
    SummonerRunner runner;

    String username = "master";
    String password = "secret";
    Set<String> authorities = Set.of("ROLE_MASTER");
    Member member = new Member(username, password, authorities);


    @Test
    void summonNonExisting() {
        when(repository.existsByUsername(username))
                .thenReturn(false);
        when(encoder.encode(password))
                .thenReturn(password);
        summoner.summon();
        verify(repository).existsByUsername(username);
        verify(encoder).encode(password);
        verify(repository).save(member);
    }

    @Test
    void summonExisting() {
        when(repository.existsByUsername(username))
                .thenReturn(true);
        summoner.summon();
        verify(repository).existsByUsername(username);
        verifyNoMoreInteractions(repository);
    }

}