package academy.everyonecodes.logic.choices;

import academy.everyonecodes.domain.Invitation;
import academy.everyonecodes.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationVisualiser extends Choice {
    private final InvitationRepository repository;

    protected InvitationVisualiser(@Value("${choice.invitation}") int choiceNumber,
                                   InvitationRepository repository) {
        super(choiceNumber);
        this.repository = repository;
    }

    @Override
    public void performTheChoice() {
        System.out.println("SHOW ALL INVITATIONS\n");
        List<Invitation> invitations = repository.findAll();
        invitations.stream()
                .forEach(invitation -> System.out.println(invitation.getName() + "\n"));

    }
}
