package academy.everyonecodes.game.players;

import academy.everyonecodes.game.moves.Move;

public interface Player {
    Move play();
    boolean wantsToPlayAgain();
}
