package academy.everyonecodes.logic;

import academy.everyonecodes.SummonerRunner;
import academy.everyonecodes.domain.Member;
import academy.everyonecodes.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MysteriousOrderCoordinatorTest {
    @Autowired
    MysteriousOrderCoordinator coordinator;
    @MockBean
    MemberRepository repository;
    @MockBean
    PasswordEncoder encoder;
    @MockBean
    SummonerRunner runner;

    @Value("${order.welcome-message}")
    String expected;

    @Test
    void getMessage() {
        String result = coordinator.getMessage();
        Assertions.assertEquals(expected, result);

    }

    @Test
    void getAllMembers() {
        coordinator.getAllMembers();
        verify(repository).findAll();
    }

    @Test
    void getAllByAuthority() {
        String authority = "authority";
        coordinator.getAllByAuthority(authority);
        verify(repository).findAllByAuthorities(authority);

    }

    @Test
    void saveMemberExisting() {
        Member member = new Member("name", "password", Set.of("test"));
        when(repository.existsByUsername(member.getUsername()))
                .thenReturn(true);
        coordinator.saveMember(member);
        verify(repository).existsByUsername(member.getUsername());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void saveMemberNonExisting() {
        Member member = new Member("name", "password", Set.of("test"));
        when(repository.existsByUsername(member.getUsername()))
                .thenReturn(false);
        coordinator.saveMember(member);
        verify(repository).existsByUsername(member.getUsername());
        verify(repository).save(member);
    }
}