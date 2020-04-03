package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.service.DiagnosisRoom;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PatientEndpoint {
    private DiagnosisRoom diagnosisRoom;

    public PatientEndpoint(DiagnosisRoom diagnosisRoom) {
        this.diagnosisRoom = diagnosisRoom;
    }

    @PostMapping("/patients")
    Patient postPatient(@RequestBody Patient patient) {
        return diagnosisRoom.diagnose(patient);
    }
}
