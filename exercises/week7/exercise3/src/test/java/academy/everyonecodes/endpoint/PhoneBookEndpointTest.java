package academy.everyonecodes.endpoint;

import academy.everyonecodes.domein.Address;
import academy.everyonecodes.domein.Contact;
import academy.everyonecodes.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PhoneBookEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ContactRepository repository;

    String url = "/contacts";
    Contact contact = new Contact("name", new Address("fake Street", "1000"));

    @Test
    void getAll() {
        restTemplate.getForObject(url, Contact[].class);
        verify(repository).findAll();
    }

    @Test
    void getByPostalCode() {
        String postalCode = "1000";
        restTemplate.getForObject(url + "/" + postalCode, Contact[].class);
        verify(repository).findAllByAddressPostalCode(postalCode);
    }

    @Test
    void post() {
        restTemplate.postForObject(url, contact, Contact.class);
        verify(repository).save(contact);
    }
}