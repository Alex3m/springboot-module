package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.dto.PatientDTO;
import academy.everyonecodes.dto.Translator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountInvoiceCoordinatorTest {
    @Autowired
    AccountInvoiceCoordinator coordinator;

    @MockBean
    Accountant accountant;
    @MockBean
    PatientVerifier verifier;
    @MockBean
    Translator translator;
    PatientDTO patientDTO = new PatientDTO("test", "test", "test", "test", "test");
    Patient patient = new Patient("test", "test", "test", "test", "test");

    @Test
    void generateInvoice() {
        when(translator.translateFromDTO(patientDTO))
                .thenReturn(patient);
        when(verifier.verify(patient))
                .thenReturn(patient);
        PatientDTO result = coordinator.generateInvoice(this.patientDTO);
        verify(translator).translateFromDTO(patientDTO);
        verify(verifier).verify(patient);
        verify(accountant).generateInvoice(patient);
        verify(translator).translateToDTO(patient);
    }

    @Test
    void getAllInvoices() {
        coordinator.getAllInvoices();
        verify(accountant).getAll();
    }

    @Test
    void markAsPaid() {
        Long id = 1l;
        coordinator.markAsPaid(id);
        verify(accountant).markAsPaid(id);
    }
}