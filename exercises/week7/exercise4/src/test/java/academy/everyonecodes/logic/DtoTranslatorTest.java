package academy.everyonecodes.logic;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.domain.Person;
import academy.everyonecodes.translator.DtoTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DtoTranslatorTest {
    @Autowired
    DtoTranslator translator;

    Person person = new Person("test", new ArrayList<>());

    @Test
    void translateNewDTOToPerson() {
        PersonDTO personDTO = new PersonDTO("test");

        Person result = translator.translateNewDTOToPerson(personDTO);
        Assertions.assertEquals(person, result);
    }

    @Test
    void translateToDTO() {
        PersonDTO expected = new PersonDTO("test", new ArrayList<>());

        PersonDTO result = translator.translateToDTO(person);
        Assertions.assertEquals(expected, result);
    }
}