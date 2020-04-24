package academy.everyonecodes.logic;

import academy.everyonecodes.domein.Address;
import academy.everyonecodes.domein.Contact;
import academy.everyonecodes.repository.AddressRepository;
import academy.everyonecodes.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRepositoryCombiner {
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public DataRepositoryCombiner(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    public Contact save(Contact contact) {
        Address address = contact.getAddress();
        address = addressRepository.save(address);
        contact.setAddress(address);
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public List<Contact> findByPostalCode(String postalCode) {
        return contactRepository.findAllByAddressPostalCode(postalCode);
    }
}
