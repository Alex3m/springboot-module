package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.logic.TreatmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TreatmentService service;

    String url = "/patients";

    Patient patient = new Patient("test", "test", "test", "test", "test");

    @Test
    void postPatient() {
        restTemplate.postForObject(url, patient, Patient.class);
        Mockito.verify(service).treatPatient(patient);
    }
}