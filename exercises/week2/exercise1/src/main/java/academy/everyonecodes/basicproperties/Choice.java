package academy.everyonecodes.basicproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Choice {
    private boolean choice;

    public Choice(
            @Value("${basic.choice}") boolean choice) {
        this.choice = choice;
    }

    public boolean get() {
        return choice;
    }
}
