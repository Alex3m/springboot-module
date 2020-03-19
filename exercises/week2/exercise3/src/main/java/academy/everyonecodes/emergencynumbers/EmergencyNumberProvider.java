package academy.everyonecodes.emergencynumbers;

import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class EmergencyNumberProvider {
    private Set<EmergencyNumber> emergencyNumbers;
    private GeneralEmergency generalEmergency;

    public EmergencyNumberProvider(PoliceEmergency policeEmergency, FireEmergency fireEmergency, GeneralEmergency generalEmergency) {
        emergencyNumbers = Set.of(policeEmergency, fireEmergency);
        this.generalEmergency = generalEmergency;
    }

    public int provide(String emergencyName) {
        return emergencyNumbers.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equalsIgnoreCase(emergencyName))
                .map(EmergencyNumber::getNumber)
                .findFirst()
                .orElse(generalEmergency.getNumber());
    }
}
