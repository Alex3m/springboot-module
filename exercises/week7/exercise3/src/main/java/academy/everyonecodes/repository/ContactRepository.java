package academy.everyonecodes.repository;

import academy.everyonecodes.domein.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByAddressPostalCode(String postalCode);
}
