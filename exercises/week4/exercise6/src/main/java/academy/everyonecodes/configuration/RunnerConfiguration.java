package academy.everyonecodes.configuration;

import academy.everyonecodes.data.Runner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("runner")
public class RunnerConfiguration {
    private List<Runner> runners;
    private Runner winner;

    @Bean
    public Runner getWinner() {
        winner = runners.get(0);
        return winner;
    }


    @Bean
    public List<Runner> getRunners() {
        return runners;
    }

    void setRunners(List<Runner> runners) {
        this.runners = runners;
    }
}
