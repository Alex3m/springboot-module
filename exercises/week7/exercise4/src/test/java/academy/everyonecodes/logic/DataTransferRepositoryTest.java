package academy.everyonecodes.logic;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.domain.Person;
import academy.everyonecodes.repository.PersonRepository;
import academy.everyonecodes.translator.DtoTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DataTransferRepositoryTest {
    @Autowired
    DataTransferRepository dataTransferRepository;

    @MockBean
    DtoTranslator dtoTranslator;
    @MockBean
    PersonRepository personRepository;

    PersonDTO personDTO = new PersonDTO("test");
    Person person1 = new Person("test1", new ArrayList<>());
    Person person2 = new Person("test2", new ArrayList<>());
    Long id1 = 1l;
    Long id2 = 2l;

    @Test
    void savePerson() {
        when(dtoTranslator.translateNewDTOToPerson(personDTO))
                .thenReturn(person1);
        when(personRepository.save(person1))
                .thenReturn(person1);
        dataTransferRepository.savePerson(personDTO);
        InOrder order = inOrder(dtoTranslator, personRepository, dtoTranslator);
        order.verify(dtoTranslator).translateNewDTOToPerson(personDTO);
        order.verify(personRepository).save(person1);
        order.verify(dtoTranslator).translateToDTO(person1);
    }

    @Test
    void findAll() {
        List<Person> repositoryReturns = List.of(person1);
        when(personRepository.findAll())
                .thenReturn(repositoryReturns);
        dataTransferRepository.findAll();

        verify(personRepository).findAll();
        verify(dtoTranslator).translateToDTO(any());
    }

    @Test
    void connectPersonsAsFriends() {
        when(personRepository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(personRepository.findById(id2))
                .thenReturn(Optional.of(person2));
        dataTransferRepository.connectPersonsAsFriends(id1, id2);
        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verify(personRepository, times(2)).save(any());
        Assertions.assertTrue(person1.getFriends().contains(person2));
        Assertions.assertTrue(person2.getFriends().contains(person1));
    }

    @Test
    void unfriendPerson() {
        when(personRepository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(personRepository.findById(id2))
                .thenReturn(Optional.of(person2));
        dataTransferRepository.unfriendPerson(id1, id2);
        verify(personRepository).findById(id1);
        verify(personRepository).findById(id2);
        verify(personRepository, times(2)).save(any());
        Assertions.assertFalse(person1.getFriends().contains(person2));
        Assertions.assertFalse(person2.getFriends().contains(person1));
    }
}