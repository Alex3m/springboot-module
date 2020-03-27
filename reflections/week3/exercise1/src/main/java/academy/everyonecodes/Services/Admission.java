package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import org.springframework.stereotype.Service;

@Service
public class Admission {
    private UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient) {
        return uuidProvider.provideUUID(patient);
    }

}
