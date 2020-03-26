package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Developer;
import academy.everyonecodes.service.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {
    private DeveloperService developerService;

    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    List<Developer> getAll() {
        return developerService.findAll();
    }

    @GetMapping("/skills/{skill}")
    List<Developer> getWithRequiredSkills(@PathVariable String skill) {
        return developerService.findBy(skill);
    }

}
