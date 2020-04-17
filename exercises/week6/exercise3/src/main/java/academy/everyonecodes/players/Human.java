package academy.everyonecodes.players;

import academy.everyonecodes.moves.Move;
import academy.everyonecodes.moves.MoveUtils;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {
    private final MoveUtils moveUtils;
    private Scanner scanner = new Scanner(System.in);

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }


    @Override
    public Move play() {

        Optional<Move> oMove = Optional.empty();
        while (oMove.isEmpty()) {
            oMove = askForMove();
        }
        return oMove.get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? (yes/no)");
        String answer = scanner.nextLine();
        answer = answer.toLowerCase();
        return answer.contains("yes");

    }

    private Optional<Move> askForMove() {
        System.out.println("Choose one move from: " + moveUtils.getNames());
        String moveName = scanner.nextLine();
        return moveUtils.getOne(moveName);

    }

}
