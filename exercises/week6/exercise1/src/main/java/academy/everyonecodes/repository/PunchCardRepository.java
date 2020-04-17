package academy.everyonecodes.repository;

import academy.everyonecodes.data.PunchCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {

}
