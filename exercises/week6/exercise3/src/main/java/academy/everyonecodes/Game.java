package academy.everyonecodes;

import academy.everyonecodes.logic.GameResultManager;
import academy.everyonecodes.moves.Move;
import academy.everyonecodes.players.Player;
import org.springframework.stereotype.Service;

@Service
public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private final Judge judge;
    private final GameResultManager resultManager;

    public Game(Player playerOne, Player playerTwo, Judge judge, GameResultManager resultManager) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.judge = judge;
        this.resultManager = resultManager;
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
        resultManager.displayStatistics();
        Move moveOne = playerOne.play();
        Move moveTwo = playerTwo.play();
        System.out.println("Player 1 chose: " + moveOne.getName());
        System.out.println("Player 2 chose: " + moveTwo.getName());
        String winner = judge.judge(moveOne, moveTwo);
        resultManager.saveResult(winner);
        System.out.println(winner);
    }

    private boolean askToPlayAgain(Player playerOne, Player playerTwo) {
        return playerOne.wantsToPlayAgain() && playerTwo.wantsToPlayAgain();
    }
}
