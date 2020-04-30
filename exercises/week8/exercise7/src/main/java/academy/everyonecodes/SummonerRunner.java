package academy.everyonecodes;

import academy.everyonecodes.logic.AncientOneSummoner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SummonerRunner {
    private final AncientOneSummoner ancientOneSummoner;

    public SummonerRunner(AncientOneSummoner ancientOneSummoner) {
        this.ancientOneSummoner = ancientOneSummoner;
    }

    @Bean
    ApplicationRunner summon() {
        return args -> {
            ancientOneSummoner.summon();
        };
    }
}
