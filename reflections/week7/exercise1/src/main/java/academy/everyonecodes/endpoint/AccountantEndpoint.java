package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Invoice;
import academy.everyonecodes.dto.PatientDTO;
import academy.everyonecodes.logic.AccountInvoiceCoordinator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AccountantEndpoint {
    private final AccountInvoiceCoordinator coordinator;

    public AccountantEndpoint(AccountInvoiceCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    @PostMapping("/patients")
    PatientDTO post(@RequestBody PatientDTO patientDTO) {
        return coordinator.generateInvoice(patientDTO);
    }

    @GetMapping("/invoices")
    List<Invoice> getAllInvoices() {
        return coordinator.getAllInvoices();
    }

    @PutMapping("/invoices/{id}/paid")
    void markAsPaid(@PathVariable Long id) {
        coordinator.markAsPaid(id);
    }
}
