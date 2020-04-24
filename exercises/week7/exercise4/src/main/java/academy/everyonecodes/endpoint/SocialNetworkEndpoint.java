package academy.everyonecodes.endpoint;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.logic.DataTransferRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class SocialNetworkEndpoint {
    private final DataTransferRepository repository;

    public SocialNetworkEndpoint(DataTransferRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    PersonDTO postPerson(@RequestBody PersonDTO personDTO) {
        return repository.savePerson(personDTO);
    }

    @GetMapping
    List<PersonDTO> getAll() {
        return repository.findAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
    void addFriends(@PathVariable Long id1, @PathVariable Long id2) {
        repository.connectPersonsAsFriends(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2) {
        repository.unfriendPerson(id1, id2);
    }

}
