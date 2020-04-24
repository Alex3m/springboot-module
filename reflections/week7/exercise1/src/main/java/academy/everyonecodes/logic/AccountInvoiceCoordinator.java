package academy.everyonecodes.logic;

import academy.everyonecodes.data.Invoice;
import academy.everyonecodes.data.Patient;
import academy.everyonecodes.dto.PatientDTO;
import academy.everyonecodes.dto.Translator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountInvoiceCoordinator {
    private final Accountant accountant;
    private final PatientVerifier verifier;
    private final Translator translator;

    public AccountInvoiceCoordinator(Accountant accountant, PatientVerifier verifier, Translator translator) {
        this.accountant = accountant;
        this.verifier = verifier;
        this.translator = translator;
    }

    public PatientDTO generateInvoice(PatientDTO patientDTO) {
        Patient patient = translator.translateFromDTO(patientDTO);
        Patient verifiedPatient = verifier.verify(patient);
        accountant.generateInvoice(verifiedPatient);
        return translator.translateToDTO(verifiedPatient);
    }

    public List<Invoice> getAllInvoices() {
        return accountant.getAll();
    }

    public void markAsPaid(Long id) {
        accountant.markAsPaid(id);
    }
}
