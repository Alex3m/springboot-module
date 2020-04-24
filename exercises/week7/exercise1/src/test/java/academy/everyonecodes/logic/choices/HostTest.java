package academy.everyonecodes.logic.choices;

import academy.everyonecodes.AppRunner;
import academy.everyonecodes.domain.Invitation;
import academy.everyonecodes.logic.AltScanner;
import academy.everyonecodes.repository.InvitationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest
class HostTest {
    @Autowired
    Host host;
    @MockBean
    AppRunner appRunner;

    @MockBean
    InvitationRepository repository;

    @MockBean
    AltScanner scanner;

    String name = "testName";
    Invitation invite = new Invitation(name);

    @Test
    void performTheChoice() {
        when(scanner.nextString())
                .thenReturn(name);
        host.performTheChoice();
        verify(repository).save(invite);
    }
}