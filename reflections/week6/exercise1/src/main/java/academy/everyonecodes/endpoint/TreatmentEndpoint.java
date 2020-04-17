package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Treatment;
import academy.everyonecodes.logic.TreatmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {
    private final TreatmentService service;

    public TreatmentEndpoint(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    List<Treatment> getAllTreatments() {
        return service.getAllTreatments();
    }

    @GetMapping("/{uuid}")
    List<Treatment> getTreatmentsForUuid(@PathVariable String uuid) {
        return service.getTreatmentByUuid(uuid);
    }
}
