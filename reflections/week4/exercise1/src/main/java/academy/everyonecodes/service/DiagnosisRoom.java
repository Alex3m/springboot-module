package academy.everyonecodes.service;

import academy.everyonecodes.data.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        String patientSummary = "  Patient with the symptoms: " + patient.getSymptoms() + "; diagnosed with: " + patient.getDiagnosis();
        System.out.println(patientSummary);
        return patient;
    }
}
