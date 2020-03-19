package academy.everyonecodes.advanced;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {
    private double decimalnumber;

    void setDecimalnumber(double decimalnumber) {
        this.decimalnumber = decimalnumber;
    }

    public double get() {
        return decimalnumber;
    }
}
