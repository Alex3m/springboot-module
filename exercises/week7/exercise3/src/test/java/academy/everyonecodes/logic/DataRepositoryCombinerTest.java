package academy.everyonecodes.logic;

import academy.everyonecodes.domein.Address;
import academy.everyonecodes.domein.Contact;
import academy.everyonecodes.repository.AddressRepository;
import academy.everyonecodes.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DataRepositoryCombinerTest {
    @Autowired
    DataRepositoryCombiner repositoryCombiner;

    @MockBean
    ContactRepository contactRepository;
    @MockBean
    AddressRepository addressRepository;

    Address address = new Address("testStreet", "1000");
    Contact contact = new Contact("test", address);

    @Test
    void save() {
        InOrder order = inOrder(addressRepository, contactRepository);
        repositoryCombiner.save(contact);
        order.verify(addressRepository).save(address);
        order.verify(contactRepository).save(contact);
    }

    @Test
    void findAll() {
        repositoryCombiner.findAll();
        verify(contactRepository).findAll();
    }

    @Test
    void findByPostalCode() {
        String postalCode = "1000";
        repositoryCombiner.findByPostalCode(postalCode);
        verify(contactRepository).findAllByAddressPostalCode(postalCode);
    }
}