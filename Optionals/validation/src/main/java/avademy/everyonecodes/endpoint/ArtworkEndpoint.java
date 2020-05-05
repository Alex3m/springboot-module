package avademy.everyonecodes.endpoint;

import avademy.everyonecodes.domain.Artwork;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/artworks")
public class ArtworkEndpoint {

    @PostMapping
    Artwork post(@Valid @RequestBody Artwork artwork) {
        return artwork;
    }
}
