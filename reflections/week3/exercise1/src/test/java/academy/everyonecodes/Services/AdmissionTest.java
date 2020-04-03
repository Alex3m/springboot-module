package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import academy.everyonecodes.clients.DiagnosesClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {
    @Autowired
    Admission admission;
    @MockBean
    DiagnosesClient diagnosesClient;

    @Test
    void admit() {
        Patient input = new Patient("John", "pain");
        Mockito.when(diagnosesClient.send(input))
                .thenReturn(input);
        Patient result = admission.admit(input);
        Mockito.verify(diagnosesClient).send(input);
        assertFalse(result.getUuid().isBlank());

    }
}