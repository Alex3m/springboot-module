package academy.everyonecodes.repository;

import academy.everyonecodes.data.GameResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameResultRepository extends MongoRepository<GameResult, String> {
}
