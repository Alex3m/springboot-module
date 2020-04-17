package academy.everyonecodes.repository;

import academy.everyonecodes.data.Countdown;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository extends MongoRepository<Countdown, String> {
}
