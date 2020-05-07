package academy.everyonecodes.repositories;

import academy.everyonecodes.domain.SteamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SteamUserRepository extends JpaRepository<SteamUser, Long> {

    Optional<SteamUser> findOneByUsername(String username);
}
