package academy.everyonecodes.endpoint;

import academy.everyonecodes.domein.Contact;
import academy.everyonecodes.logic.DataRepositoryCombiner;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class PhoneBookEndpoint {
    private final DataRepositoryCombiner repository;

    public PhoneBookEndpoint(DataRepositoryCombiner repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Contact> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{postalCode}")
    List<Contact> getByPostalCode(@PathVariable String postalCode) {
        return repository.findByPostalCode(postalCode);
    }

    @PostMapping
    Contact post(@Valid @RequestBody Contact contact) {
        return repository.save(contact);

    }
}
