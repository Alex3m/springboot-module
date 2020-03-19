package academy.everyonecodes.emergencynumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeneralEmergencyTest {
    @Autowired
    GeneralEmergency generalEmergency;

    @Test
    void getName() {
        String expected = "General emergency";
        String result = generalEmergency.getName();
        assertEquals(expected, result);
    }

    @Test
    void getTelephone() {
        int expected = 112;
        int result = generalEmergency.getNumber();
        assertEquals(expected, result);
    }
}