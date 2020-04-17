package academy.everyonecodes.players;

import academy.everyonecodes.moves.Move;

import java.util.List;
import java.util.Random;

public class Computer implements Player {
    private final List<Move> moves;

    public Computer(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Move play() {
        Random random = new Random();
        int randomMoveIndex = random.nextInt(3);
        return moves.get(randomMoveIndex);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
