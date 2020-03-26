package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Academy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {
    private List<Academy> academies;

    public AcademyEndpoint(List<Academy> academies) {
        this.academies = academies;
    }

    @GetMapping
    List<Academy> get(){
        return academies;
    }
}
