package academy.everyonecodes.amazinghelloworld.amazing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloTest {
    @Autowired
    Hello hello;
    @Test
    void get() {
        String expected = "Hello";
        String result = hello.get();
        assertEquals(expected, result);
    }
}