package academy.everyonecodes.repository;

import academy.everyonecodes.domein.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
