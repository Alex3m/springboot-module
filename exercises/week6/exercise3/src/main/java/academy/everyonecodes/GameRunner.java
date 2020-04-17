package academy.everyonecodes;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {
    @Bean
    ApplicationRunner play(Game game) {
        return args -> game.play();
    }
}


