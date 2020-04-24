package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Invoice;
import academy.everyonecodes.dto.PatientDTO;
import academy.everyonecodes.logic.AccountInvoiceCoordinator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AccountantEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    AccountInvoiceCoordinator coordinator;
    String urlInvoices = "/invoices";

    @Test
    void post() {
        String urlPatients = "/patients";
        PatientDTO patientDTO = new PatientDTO("test", "test", "test", "test", "test");
        restTemplate.postForObject(urlPatients, patientDTO, PatientDTO.class);
        verify(coordinator).generateInvoice(patientDTO);

    }

    @Test
    void getAllInvoices() {
        restTemplate.getForObject(urlInvoices, Invoice[].class);
        verify(coordinator).getAllInvoices();
    }

    @Test
    void markAsPaid() {
        Long id = 1L;
        restTemplate.put(urlInvoices+"/"+id+"/paid", null);
        verify(coordinator).markAsPaid(id);
    }
}