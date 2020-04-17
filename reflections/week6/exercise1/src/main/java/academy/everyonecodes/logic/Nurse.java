package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.data.Treatment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final String treatment;

    public Nurse(
            @Value("${nurse.treatment}") String treatment) {
        this.treatment = treatment;
    }

    public Patient applyTreatment(Patient patient) {
        patient.setTreatment(treatment);
        return patient;
    }
}
