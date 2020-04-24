package academy.everyonecodes.logic.choices;

import academy.everyonecodes.domain.Invitation;
import academy.everyonecodes.logic.AltScanner;
import academy.everyonecodes.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Host extends Choice {
    private final InvitationRepository repository;
    private final AltScanner scanner;

    protected Host(
            @Value("${choice.invite}") int invitationChoice,
            InvitationRepository repository, AltScanner scanner) {
        super(invitationChoice);
        this.repository = repository;
        this.scanner = scanner;
    }


    @Override
    public void performTheChoice() {
        System.out.println("Write the person’s name: ");
        String name = scanner.nextString();
        repository.save(new Invitation(name));
        System.out.println("-" + name + " was added to the list.\n");
    }
}
