package academy.everyonecodes.advanced;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NaturalNumberTest {
    @Autowired
    NaturalNumber naturalNumber;

    @Test
    void get() {
        int expected = 369;
        int result = naturalNumber.get();
        assertEquals(expected, result);

    }
}