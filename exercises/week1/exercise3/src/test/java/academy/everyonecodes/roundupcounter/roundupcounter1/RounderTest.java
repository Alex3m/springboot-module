package academy.everyonecodes.roundupcounter.roundupcounter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RounderTest {
    @Autowired
    Rounder rounder;

    @Test
    void roundUp() {
        double input = 1.5;
        double expected = 2;
        double result = rounder.roundUp(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void roundDown() {
        double input = 1.5;
        double expected = 1;
        double result = rounder.roundDown(input);
        Assertions.assertEquals(expected, result);
    }
}