package academy.everyonecodes.players;

import academy.everyonecodes.moves.Move;
import academy.everyonecodes.moves.MoveUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Player playerOne(MoveUtils moveUtils) {
        return new Human(moveUtils);
    }

    @Bean
    Player playerTwo(List<Move> moves) {
        return new Computer(moves);
    }
}
