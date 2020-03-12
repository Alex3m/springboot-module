package academy.everyonecodes.amazinggoodbye.amazinggoodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodbyeTest {
    @Autowired
    Goodbye goodbye;

    @Test
    void get() {
        String expected = "Goodbye";
        String result = goodbye.get();

        assertEquals(expected, result);
    }
}