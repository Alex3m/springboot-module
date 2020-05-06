package academy.everyonecodes.repository;

import academy.everyonecodes.domain.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver, String> {
    Optional<Driver> findOneByUsername(String username);

    boolean existsByUsername(String username);
}
