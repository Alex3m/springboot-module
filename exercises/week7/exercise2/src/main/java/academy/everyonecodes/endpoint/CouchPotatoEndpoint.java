package academy.everyonecodes.endpoint;

import academy.everyonecodes.domein.Film;
import academy.everyonecodes.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class CouchPotatoEndpoint {
    private FilmRepository repository;

    public CouchPotatoEndpoint(FilmRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Film> getFilms() {
        return repository.findAll();
    }

    @PostMapping
    Film postFilm(@Valid @RequestBody Film film) {
        repository.save(film);
        return film;
    }
}
