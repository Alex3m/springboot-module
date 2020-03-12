package academy.everyonecodes.amazinggoodbye.amazinggoodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WorldTest {
    @Autowired
    World world;

    @Test
    void get() {
        String expected = "World";
        String result = world.get();
        Assertions.assertEquals(expected, result);
    }
}