package academy.everyonecodes.logic;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.domain.Person;
import academy.everyonecodes.repository.PersonRepository;
import academy.everyonecodes.translator.DtoTranslator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DataTransferRepository {
    private final PersonRepository repository;
    private final DtoTranslator translator;

    public DataTransferRepository(PersonRepository repository, DtoTranslator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    public PersonDTO savePerson(PersonDTO personDTO) {
        Person person = translator.translateNewDTOToPerson(personDTO);
        Person savedPerson = repository.save(person);
        return translator.translateToDTO(savedPerson);
    }

    public List<PersonDTO> findAll() {
        List<Person> personList = repository.findAll();
        return personList.stream()
                .map(person -> translator.translateToDTO(person))
                .collect(Collectors.toList());
    }

    public void connectPersonsAsFriends(Long id1, Long id2) {
        Optional<Person> oFirstPerson = repository.findById(id1);
        Optional<Person> oSecondPerson = repository.findById(id2);
        if (oFirstPerson.isPresent() && oSecondPerson.isPresent()) {
            Person firstPerson = oFirstPerson.get();
            Person secondPerson = oSecondPerson.get();
            firstPerson.getFriends().add(secondPerson);
            secondPerson.getFriends().add(firstPerson);
            repository.save(firstPerson);
            repository.save(secondPerson);
        }
    }

    public void unfriendPerson(Long id1, Long id2) {
        Optional<Person> oFirstPerson = repository.findById(id1);
        Optional<Person> oSecondPerson = repository.findById(id2);
        if (oFirstPerson.isPresent() && oSecondPerson.isPresent()) {
            Person firstPerson = oFirstPerson.get();
            Person secondPerson = oSecondPerson.get();
            firstPerson.getFriends().remove(secondPerson);
            secondPerson.getFriends().remove(firstPerson);
            repository.save(firstPerson);
            repository.save(secondPerson);
        }
    }
}
