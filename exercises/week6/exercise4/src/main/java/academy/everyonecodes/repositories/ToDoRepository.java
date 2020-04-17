package academy.everyonecodes.repositories;

import academy.everyonecodes.data.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
