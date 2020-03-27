package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdmissionTest {
    @Autowired
    Admission admission;

    @Test
    void admit() {
        Patient input = new Patient("John", "pain");
        Patient result = admission.admit(input);
        assertFalse(result.getUuid().isBlank());

    }
}