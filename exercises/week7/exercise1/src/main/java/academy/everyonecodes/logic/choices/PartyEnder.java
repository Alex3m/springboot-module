package academy.everyonecodes.logic.choices;

import academy.everyonecodes.logic.AltScanner;
import academy.everyonecodes.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PartyEnder extends Choice {
    private final InvitationRepository repository;
    private final AltScanner scanner;

    protected PartyEnder(@Value("${choice.concludeparty}") int choiceNumber,
                         InvitationRepository repository, AltScanner scanner) {
        super(choiceNumber);
        this.repository = repository;
        this.scanner = scanner;
    }

    @Override
    public void performTheChoice() {
        System.out.println("> Do you want to conclude the party? (y, N): ");
        String answer = scanner.nextString();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("- The current party was concluded.");
            repository.deleteAll();
            return;
        }
        System.out.println(" - The current party is still ongoing.");
    }
}
