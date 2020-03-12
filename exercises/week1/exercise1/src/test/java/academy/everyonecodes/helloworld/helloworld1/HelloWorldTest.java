package academy.everyonecodes.helloworld.helloworld1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldTest {
    @Autowired
    HelloWorld helloWorld;

    @Test
    void get() {
        String expected = "Hello World";
        String result = helloWorld.get();

        assertEquals(expected, result);
    }
}