package academy.everyonecodes.service;

import academy.everyonecodes.data.Diagnosis;
import academy.everyonecodes.data.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {
    private List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void diagnose(Patient patient) {
        String patientSymptoms = patient.getSymptoms();
        String diagnosisName = diagnoses.stream()
                .filter(diagnosis -> diagnosis.getSymptoms().equals(patientSymptoms))
                .map(diagnosis -> diagnosis.getName())
                .findFirst()
                .orElse("Lupus");
        patient.setDiagnosis(diagnosisName);

    }
}
