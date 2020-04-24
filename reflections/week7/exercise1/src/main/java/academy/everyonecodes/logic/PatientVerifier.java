package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientVerifier {
    private final PatientRepository repository;

    public PatientVerifier(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient verify(Patient patient) {
        Optional<Patient> optionalPatient = repository.findByUuid(patient.getUuid());
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        }
        return repository.save(patient);
    }
}
