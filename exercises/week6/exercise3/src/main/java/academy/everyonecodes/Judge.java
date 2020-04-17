package academy.everyonecodes;

import academy.everyonecodes.moves.Move;
import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move moveOne, Move moveTwo) {
        if (moveOne.getDefeats().equals(moveTwo.getName())) {
            return "Player 1 wins";
        }
        if (moveTwo.getDefeats().equals(moveOne.getName())) {
            return "Player 2 wins";
        }
        return "Nobody wins";
    }
}
