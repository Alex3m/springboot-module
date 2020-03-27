package academy.everyonecodes.endpoints;

import academy.everyonecodes.Data.Patient;
import academy.everyonecodes.Services.Admission;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }
    @PostMapping
    Patient postPatient(@RequestBody Patient patient){
        return admission.admit(patient);
    }
}
