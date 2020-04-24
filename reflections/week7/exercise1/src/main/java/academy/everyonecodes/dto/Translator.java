package academy.everyonecodes.dto;

import academy.everyonecodes.data.Patient;
import org.springframework.stereotype.Service;

@Service
public class Translator {

    public PatientDTO translateToDTO(Patient patient) {
        String uuid = patient.getUuid();
        String name = patient.getName();
        String symptoms = patient.getSymptoms();
        String diagnosis = patient.getDiagnosis();
        String treatment = patient.getTreatment();
        return new PatientDTO(uuid, name, symptoms, diagnosis, treatment);
    }

    public Patient translateFromDTO(PatientDTO patientDTO) {
        String uuid = patientDTO.getUuid();
        String name = patientDTO.getName();
        String symptoms = patientDTO.getSymptoms();
        String diagnosis = patientDTO.getDiagnosis();
        String treatment = patientDTO.getTreatment();
        return new Patient(uuid, name, symptoms, diagnosis, treatment);
    }
}
