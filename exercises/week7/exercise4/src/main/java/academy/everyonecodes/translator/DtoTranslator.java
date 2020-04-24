package academy.everyonecodes.translator;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DtoTranslator {

    public Person translateNewDTOToPerson(PersonDTO personDTO) {
        String name = personDTO.getName();
        List<Person> friends = new ArrayList<>();
        return new Person(name, friends);
    }

    public PersonDTO translateToDTO(Person person) {
        Long id = person.getId();
        String name = person.getName();
        List<String> friends = person.getFriends().stream()
                .map(Person::getName)
                .collect(toList());
        return new PersonDTO(id, name, friends);
    }
}
