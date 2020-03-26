package academy.everyonecodes.service;

import academy.everyonecodes.data.Developer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeveloperServiceTest {
@Autowired
DeveloperService developerService;
    @Test
    void findAll() {
        List<Developer> expected = List.of(new Developer("name1", Set.of("skill1")), new Developer("name2", Set.of("skill2")));
        List<Developer> result = developerService.findAll();
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String skills) {
        List<Developer> result = developerService.findBy(skills);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(List.of(new Developer("name1", Set.of("skill1"))), "skill1"),
                Arguments.of(List.of(new Developer("name2", Set.of("skill2"))), "skill2"),
                Arguments.of(List.of(), "skill3")
        );
    }
}