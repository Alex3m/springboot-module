package academy.everyonecodes.game;

import academy.everyonecodes.game.moves.Move;
import academy.everyonecodes.game.players.Player;
import org.springframework.stereotype.Service;

@Service
public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private final Judge judge;

    public Game(Player playerOne, Player playerTwo, Judge judge) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.judge = judge;
    }

    public void play() {
        System.out.println("Welcome!");
        boolean wantToPlay;

        do {
            playOneRound(playerOne, playerTwo);
            wantToPlay = askToPlayAgain(playerOne, playerTwo);
        } while (wantToPlay);
        System.out.println("Goodbye");
    }

    private void playOneRound(Player playerOne, Player playerTwo) {
        Move moveOne = playerOne.play();
        Move moveTwo = playerTwo.play();
        System.out.println("Player 1 chose: " + moveOne.getName());
        System.out.println("Player 2 chose: " + moveTwo.getName());
        String winner = judge.judge(moveOne, moveTwo);
        System.out.println(winner);
    }

    private boolean askToPlayAgain(Player playerOne, Player playerTwo) {
        return playerOne.wantsToPlayAgain() && playerTwo.wantsToPlayAgain();
    }
}
