package academy.everyonecodes.configutation;

import academy.everyonecodes.logic.choices.Choice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChoiceConfiguration {
    private List<Choice> choices;

    @Bean
    List<Choice> getChoices(){
        return choices;
    }
}
