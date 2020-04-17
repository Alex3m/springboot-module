package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.data.Treatment;
import academy.everyonecodes.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository repository;
    private final Nurse nurse;

    public TreatmentService(TreatmentRepository repository, Nurse nurse) {
        this.repository = repository;
        this.nurse = nurse;
    }

    public List<Treatment> getAllTreatments() {
        return repository.findAll();
    }

    public List<Treatment> getTreatmentByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    public Patient treatPatient(Patient patient) {
        Patient treatedPatient = nurse.applyTreatment(patient);
        Treatment patientTreatment = translatePatientToTreatment(treatedPatient);
        repository.save(patientTreatment);
        return treatedPatient;
    }

    Treatment translatePatientToTreatment(Patient treatedPatient) {
        String uuid = treatedPatient.getUuid();
        String name = treatedPatient.getName();
        String symptoms = treatedPatient.getSymptoms();
        String diagnosis = treatedPatient.getDiagnosis();
        String treatment = treatedPatient.getTreatment();
        return new Treatment(uuid, name, symptoms, diagnosis, treatment);
    }

}
