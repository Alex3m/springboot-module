package academy.everyonecodes.advanced;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class NaturalNumber {
    private int naturalnumber;

    void setNaturalnumber(int naturalnumber) {
        this.naturalnumber = naturalnumber;
    }

    public int get() {
        return naturalnumber;
    }
}
