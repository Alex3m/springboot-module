package academy.everyonecodes.endpoint;

import academy.everyonecodes.data.Runner;
import academy.everyonecodes.service.MarathonService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {
    private MarathonService marathonService;

    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @PostMapping
    void post(@RequestBody Runner runner) {
        marathonService.add(runner);
    }

    @GetMapping("/winner")
    Runner getWinner() {
        Optional<Runner> oWinner = marathonService.findWinner();
        if (oWinner.isPresent()) {
            return oWinner.get();
        }
        return null;
    }

}
