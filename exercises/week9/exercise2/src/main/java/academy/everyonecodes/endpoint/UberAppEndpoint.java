package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.domain.Ride;
import academy.everyonecodes.dto.DriverDTO;
import academy.everyonecodes.dto.RideDTO;
import academy.everyonecodes.service.UberService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class UberAppEndpoint {
    private final UberService service;

    public UberAppEndpoint(UberService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    Driver post(@RequestBody Driver driver) {
        return service.save(driver);
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<DriverDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    RideDTO postRide(@PathVariable Long id, @RequestBody Ride ride) {
        return service.saveAndLink(ride, id);
    }
}
