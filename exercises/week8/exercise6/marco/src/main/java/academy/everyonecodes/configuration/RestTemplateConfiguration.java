package academy.everyonecodes.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    private String username;
    private String password;

    public RestTemplateConfiguration(
            @Value("${user.name}") String username,
            @Value("${user.password}") String password) {
        this.username = username;
        this.password = password;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .basicAuthentication(username, password)
                .build();
    }
}
