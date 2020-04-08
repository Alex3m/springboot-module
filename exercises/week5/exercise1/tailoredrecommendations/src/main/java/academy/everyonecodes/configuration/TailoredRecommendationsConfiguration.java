package academy.everyonecodes.configuration;

import academy.everyonecodes.data.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
@ConfigurationProperties("tailored")
public class TailoredRecommendationsConfiguration {
    Set<TailoredRecommendation> recommendations;

    void setRecommendations(Set<TailoredRecommendation> recommendations) {
        this.recommendations = recommendations;
    }

    @Bean
    public Set<TailoredRecommendation> recommendations() {
        return recommendations;
    }
}
