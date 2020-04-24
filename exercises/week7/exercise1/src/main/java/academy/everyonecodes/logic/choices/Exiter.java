package academy.everyonecodes.logic.choices;

import academy.everyonecodes.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Exiter extends Choice {

    protected Exiter(@Value("${choice.exit}") int choiceNumber) {
        super(choiceNumber);
    }

    @Override
    public void performTheChoice() {
        System.exit(0);
    }
}
