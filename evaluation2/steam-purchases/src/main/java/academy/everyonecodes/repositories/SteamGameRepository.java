package academy.everyonecodes.repositories;

import academy.everyonecodes.domain.SteamGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SteamGameRepository extends JpaRepository<SteamGame, Long> {

    Optional<SteamGame> findOneByGameID(String gameID);

}
