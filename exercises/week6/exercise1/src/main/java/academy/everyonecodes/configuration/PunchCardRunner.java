package academy.everyonecodes.configuration;

import academy.everyonecodes.logic.PunchCardService;
import academy.everyonecodes.repository.PunchCardRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PunchCardRunner {
    private final PunchCardService punchCardService;

    public PunchCardRunner(PunchCardService punchCardService) {
        this.punchCardService = punchCardService;
    }

    @Bean
    ApplicationRunner funPunchCards(PunchCardRepository punchCardRepository) {
        return args -> {
            punchCardService.applyTimeStamp();
        };
    }
}
