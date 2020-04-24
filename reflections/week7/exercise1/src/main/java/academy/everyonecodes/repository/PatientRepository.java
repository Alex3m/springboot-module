package academy.everyonecodes.repository;

import academy.everyonecodes.data.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUuid(String uuid);
}
