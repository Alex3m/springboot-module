package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.ToDo;
import academy.everyonecodes.logic.ToDoManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {
    private final ToDoManager toDoManager;

    public ToDosEndpoint(ToDoManager toDoManager) {
        this.toDoManager = toDoManager;
    }

    @GetMapping
    List<ToDo> getAll() {
        return toDoManager.getAll();
    }

    @GetMapping("{id}")
    ToDo getOne(@PathVariable String id) {
        return toDoManager.getById(id).orElse(null);
    }

    @PostMapping
    ToDo postToDo(@RequestBody ToDo toDo) {
        return toDoManager.post(toDo);
    }

    @PutMapping("{id}/done")
    ToDo put(@PathVariable String id) {
        return toDoManager.markAsDone(id).orElse(null);
    }

    @DeleteMapping("{id}")
    void deleteOne(@PathVariable String id) {
        toDoManager.deleteOne(id);
    }
}
