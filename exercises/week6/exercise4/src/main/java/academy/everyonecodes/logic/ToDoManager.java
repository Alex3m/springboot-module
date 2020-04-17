package academy.everyonecodes.logic;

import academy.everyonecodes.data.ToDo;
import academy.everyonecodes.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {
    private final ToDoRepository toDoRepository;

    public ToDoManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getById(String id) {
        return toDoRepository.findById(id);
    }

    public ToDo post(ToDo toDo) {
        toDoRepository.save(toDo);
        return toDo;
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> oToDo = toDoRepository.findById(id);
        oToDo.ifPresent(toDo ->
        {
            toDo.setDone(true);
            toDoRepository.save(toDo);
        });
        return oToDo;
    }

    public void deleteOne(String id) {
        toDoRepository.deleteById(id);
    }

}
