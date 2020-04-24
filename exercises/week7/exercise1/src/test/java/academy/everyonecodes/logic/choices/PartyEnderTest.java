package academy.everyonecodes.logic.choices;

import academy.everyonecodes.AppRunner;
import academy.everyonecodes.logic.AltScanner;
import academy.everyonecodes.repository.InvitationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class PartyEnderTest {
    @Autowired
    PartyEnder partyEnder;
    @MockBean
    AltScanner scanner;
    @MockBean
    InvitationRepository repository;
    @MockBean
    AppRunner appRunner;

    @Test
    void performTheChoiceWithYes() {
        when(scanner.nextString())
                .thenReturn("y");
        partyEnder.performTheChoice();
        verify(repository).deleteAll();

    }

    @Test
    void performTheChoiceWithDifferentThanYes() {
        when(scanner.nextString())
                .thenReturn("No");
        partyEnder.performTheChoice();
        verify(repository, never()).deleteAll();
    }
}