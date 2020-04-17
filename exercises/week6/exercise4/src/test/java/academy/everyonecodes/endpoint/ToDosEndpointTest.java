package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.ToDo;
import academy.everyonecodes.logic.ToDoManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ToDoManager manager;
    String url = "/todos";
    String dummyId = "test";
    ToDo toDo = new ToDo("test", false);
    ToDo markedAsDone = new ToDo("test", true);

    @Test
    void getAll() {
        restTemplate.getForObject(url, List.class);
        verify(manager).getAll();
    }

    @Test
    void getOne() {
        when(manager.getById(dummyId))
                .thenReturn(Optional.of(toDo));
        restTemplate.getForObject(url + "/" + dummyId, ToDo.class);
        verify(manager).getById(dummyId);
    }

    @Test
    void postToDo() {
        restTemplate.postForObject(url, toDo, ToDo.class);
        verify(manager).post(toDo);
    }

    @Test
    void put() {

        when(manager.markAsDone(dummyId))
                .thenReturn(Optional.ofNullable(markedAsDone));

        restTemplate.put(url + "/" + dummyId + "/" + "done", dummyId, ToDo.class);
        verify(manager).markAsDone(dummyId);
    }

    @Test
    void deleteOne() {
        restTemplate.delete(url + "/" + dummyId);
        verify(manager).deleteOne(dummyId);
    }
}