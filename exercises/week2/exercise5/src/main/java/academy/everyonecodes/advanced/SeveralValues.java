package academy.everyonecodes.advanced;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("several")
public class SeveralValues {
    private List<Integer> naturalnumbers;
    private List<Double> decimalnumbers;
    private List<String> words;
    private List<Boolean> choices;


    void setNaturalnumbers(List<Integer> naturalnumbers) {
        this.naturalnumbers = naturalnumbers;
    }

    void setDecimalnumbers(List<Double> decimalnumbers) {
        this.decimalnumbers = decimalnumbers;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setChoices(List<Boolean> choices) {
        this.choices = choices;
    }

    public List<Integer> getNaturalnumbers() {
        return naturalnumbers;
    }

    public List<Double> getDecimalnumbers() {
        return decimalnumbers;
    }

    public List<String> getWords() {
        return words;
    }

    public List<Boolean> getChoices() {
        return choices;
    }
}
