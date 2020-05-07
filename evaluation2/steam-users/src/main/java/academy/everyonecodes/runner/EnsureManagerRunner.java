package academy.everyonecodes.runner;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.logic.ManagerInitializer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnsureManagerRunner {
    private SteamUser manager;

    void setManager(SteamUser manager) {
        this.manager = manager;
    }

    @Bean
    ApplicationRunner initialize(ManagerInitializer manager) {
        return args -> {
            manager.initialize();
        };
    }

}
