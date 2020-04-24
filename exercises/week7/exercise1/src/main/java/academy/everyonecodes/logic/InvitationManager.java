package academy.everyonecodes.logic;

import academy.everyonecodes.logic.choices.Choice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationManager {
    private final List<Choice> choices;
    private final AltScanner scanner;

    public InvitationManager(List<Choice> choices, AltScanner scanner) {
        this.choices = choices;
        this.scanner = scanner;
    }

    public void manage() {

        do {
            displayTheMenu();
            int currentChoice = scanner.nextInteger();
            choices.stream()
                    .filter(choice -> choice.getChoiceNumber() == currentChoice)
                    .forEach(choice -> choice.performTheChoice());
        } while (true);
    }

    private void displayTheMenu() {
        System.out.println("The Great Gatsby Party Invitation Manager\n" +
                "MENU\n" +
                "\n" +
                "1.- Invite a person.\n" +
                "2.- Show all invitations.\n" +
                "3.- Conclude the current party.\n" +
                "4.- Exit.\n" +
                "> Choose one option (1-4):");
    }
}
