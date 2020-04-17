package academy.everyonecodes.repository;

import academy.everyonecodes.data.Accumulation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccumulationRepository extends MongoRepository<Accumulation, String> {
}
