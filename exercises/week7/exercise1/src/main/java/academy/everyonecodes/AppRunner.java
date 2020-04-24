package academy.everyonecodes;

import academy.everyonecodes.logic.InvitationManager;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRunner {
    @Bean
    ApplicationRunner runTheGreatGatsby(InvitationManager invitationManager){
        return args -> {
            invitationManager.manage();
        };

    }
}
