package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import academy.everyonecodes.clients.DiagnosesClient;
import org.springframework.stereotype.Service;

@Service
public class Admission {
    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }

    public Patient admit(Patient patient) {
        Patient patientWithUUID = uuidProvider.provideUUID(patient);
        diagnosesClient.send(patientWithUUID);
        return patientWithUUID;
    }

}
