package academy.everyonecodes.emergencynumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeneralEmergency implements EmergencyNumber {
    private String name;
    private int telephone;

    public GeneralEmergency(
            @Value("${emergency.general.name}") String name,
            @Value("${emergency.general.number}") int telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return telephone;
    }
}
