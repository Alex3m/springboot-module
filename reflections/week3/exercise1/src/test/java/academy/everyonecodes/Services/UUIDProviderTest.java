package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UUIDProviderTest {
    @Autowired
    UUIDProvider uuidProvider;
    private Patient input = new Patient("John", "pain");

    @Test
    void provideUUID() {

        Patient expected = uuidProvider.provideUUID(input);
        Patient result = uuidProvider.provideUUID(input);
        Assertions.assertEquals(expected, result);

    }

    @Test
    void findUUIDWithExistingPatient() {
        Patient patient = uuidProvider.provideUUID(input);
        String expected = input.getUuid();
        String result = uuidProvider.findUUID(patient.getName());
        Assertions.assertEquals(expected, result);
    }
}