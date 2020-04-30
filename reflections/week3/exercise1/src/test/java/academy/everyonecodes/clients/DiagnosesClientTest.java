package academy.everyonecodes.clients;

import academy.everyonecodes.Data.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DiagnosesClientTest {
    @Autowired
    DiagnosesClient diagnosesClient;
    @MockBean
    RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    String url;

    Patient patient = new Patient(null, "name1","symptoms");
    Patient patientReturned = new Patient("01","name1", "symptoms");

    @Test
    void send() {
        when(restTemplate.postForObject(url, patient, Patient.class))
                .thenReturn(patientReturned);
        Patient response = diagnosesClient.send(patient);
        verify(restTemplate).postForObject(url, patient, Patient.class);
        Assertions.assertEquals(patientReturned, response);
    }
}