package academy.everyonecodes.logic;

import academy.everyonecodes.data.ToDo;
import academy.everyonecodes.repositories.ToDoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ToDoManagerTest {
    @Autowired
    ToDoManager manager;

    @MockBean
    ToDoRepository repository;

    String id = "testId";
    ToDo toDo = new ToDo("test", false);
    ToDo doneToDo = new ToDo("test", true);


    @Test
    void getAll() {
        manager.getAll();
        verify(repository).findAll();
    }

    @Test
    void getById() {
        manager.getById(id);
        verify(repository).findById(id);
    }

    @Test
    void post() {
        manager.post(toDo);
        verify(repository).save(toDo);
    }

    @Test
    void markAsDone() {
        when(repository.findById(id))
                .thenReturn(Optional.of(toDo));
        Optional<ToDo> oResult = manager.markAsDone(id);
        ToDo expected = doneToDo;

        Assertions.assertTrue(oResult.isPresent());
        Assertions.assertEquals(expected, oResult.get());

    }

    @Test
    void deleteOne() {
        manager.deleteOne(id);
        verify(repository).deleteById(id);
    }
}