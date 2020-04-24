package academy.everyonecodes.logic.choices;

import academy.everyonecodes.AppRunner;
import academy.everyonecodes.repository.InvitationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
class InvitationVisualiserTest {
    @Autowired
    InvitationVisualiser invitationVisualiser;

    @MockBean
    InvitationRepository repository;

    @MockBean
    AppRunner appRunner;

    @Test
    void performTheChoice() {
        invitationVisualiser.performTheChoice();
        verify(repository).findAll();
    }
}