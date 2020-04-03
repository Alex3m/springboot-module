package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.service.DiagnosisRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    DiagnosisRoom diagnosisRoom;

    String url = "/patients";


    Patient patient = new Patient("01", "name1", "sneezing, nasal congestion", null);
    Patient expected = new Patient("01", "name1", "sneezing, nasal congestion", "allergy");

    @Test
    void postPatient() {
        when(diagnosisRoom.diagnose(patient))
                .thenReturn(expected);
        Patient response = restTemplate.postForObject(url, patient, Patient.class);
        verify(diagnosisRoom).diagnose(patient);
        Assertions.assertEquals(expected, response);
    }
}