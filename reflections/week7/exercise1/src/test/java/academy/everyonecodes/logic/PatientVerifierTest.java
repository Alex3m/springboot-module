package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class PatientVerifierTest {
    @Autowired
    PatientVerifier verifier;
    @MockBean
    PatientRepository repository;
    Patient patient = new Patient("test", "test", "test", "test", "test");

    @Test
    void verifyIfNotFound() {
        Patient verifiedPatient = verifier.verify(patient);
        verify(repository).findByUuid(patient.getUuid());
        verify(repository).save(patient);
    }

    @Test
    void verifyIfFound() {
        when(repository.findByUuid(patient.getUuid()))
                .thenReturn(Optional.of(patient));
        Patient verifiedPatient = verifier.verify(patient);
        verify(repository).findByUuid(patient.getUuid());
        verify(repository, never()).save(patient);
    }
}