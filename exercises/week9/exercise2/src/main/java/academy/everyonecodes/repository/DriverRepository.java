package academy.everyonecodes.repository;

import academy.everyonecodes.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsByUsername(String username);
}
