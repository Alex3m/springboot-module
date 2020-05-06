package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.dto.DriverDTO;
import academy.everyonecodes.logic.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {
    private final DriverService service;

    public DriverEndpoint(DriverService service) {
        this.service = service;
    }

    @PostMapping
    Driver post(@RequestBody Driver driver) {
        return service.saveDriver(driver);
    }

    @GetMapping("/{id}")
    DriverDTO getDriverBy(@PathVariable String id) {
        return service.getDriverBy(id).orElse(null);
    }

    @PutMapping("/{id}/available")
    void makeAvailableDriverWith(@PathVariable String id) {
        service.makeAvailable(id);
    }

    @PutMapping("/{id}/unavailable")
    void makeUnavailableDriverWith(@PathVariable String id) {
        service.makeUnAvailable(id);
    }
}
