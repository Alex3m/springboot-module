package academy.everyonecodes.logic;

import academy.everyonecodes.data.Invoice;
import academy.everyonecodes.data.Patient;
import academy.everyonecodes.repository.InvoiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AccountantTest {
    @Autowired
    Accountant accountant;
    @MockBean
    InvoiceRepository repository;

    Patient patient = new Patient("test", "test", "test", "test", "test");
    Invoice expected = new Invoice(90, false, patient);

    @Test
    void generateInvoice() {
        Invoice result = accountant.generateInvoice(patient);
        verify(repository).save(result);
        assertEquals(expected, result);
    }
}