package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.logic.TreatmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final TreatmentService service;

    public PatientEndpoint(TreatmentService service) {
        this.service = service;
    }

    @PostMapping
    Patient postPatient(@RequestBody Patient patient) {
        return service.treatPatient(patient);
    }
}
