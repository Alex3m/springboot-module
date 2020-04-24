package academy.everyonecodes.endpoint;

import academy.everyonecodes.domein.Film;
import academy.everyonecodes.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CouchPotatoEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    FilmRepository repository;

    String url = "/films";

    @Test
    void getFilms() {
        restTemplate.getForObject(url, Film[].class);
        verify(repository).findAll();
    }

    @Test
    void postFilm() {
        Film film = new Film("test", 1);
        restTemplate.postForObject(url, film, Film.class);
        verify(repository).save(film);
    }
}