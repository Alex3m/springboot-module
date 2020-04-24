package academy.everyonecodes.endpoint;

import academy.everyonecodes.DTO.PersonDTO;
import academy.everyonecodes.logic.DataTransferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SocialNetworkEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    DataTransferRepository repository;

    String url = "/persons";
    Long id1 = 1l;
    Long id2 = 2l;
    PersonDTO personDTO = new PersonDTO("test");


    @Test
    void postPerson() {
        restTemplate.postForObject(url, personDTO, PersonDTO.class);
        verify(repository).savePerson(personDTO);
    }

    @Test
    void getAll() {
        restTemplate.getForObject(url, PersonDTO[].class);
        verify(repository).findAll();
    }

    @Test
    void addFriends() {
        restTemplate.put(url + "/" + id1 + "/friend/" + id2, null);
        verify(repository).connectPersonsAsFriends(id1, id2);
    }

    @Test
    void unfriend() {
        restTemplate.put(url + "/" + id1 + "/unfriend/" + id2, null);
        verify(repository).unfriendPerson(id1, id2);
    }
}