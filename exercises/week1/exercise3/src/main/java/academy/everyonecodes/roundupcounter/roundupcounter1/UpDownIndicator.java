package academy.everyonecodes.roundupcounter.roundupcounter1;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number) {
        double numberRoundDown = rounder.roundDown(number);
        double difference = number - numberRoundDown;
        double numberForSame = 0.5;
        if (number % numberForSame == 0) {
            return "SAME";
        }
        if (difference > numberForSame) {
            return "UP";
        }
        return "DOWN";
    }

}
