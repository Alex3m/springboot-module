package academy.everyonecodes.players;

import academy.everyonecodes.moves.Move;

public interface Player {
    Move play();

    boolean wantsToPlayAgain();
}
