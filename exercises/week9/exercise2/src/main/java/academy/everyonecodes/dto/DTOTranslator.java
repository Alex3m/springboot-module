package academy.everyonecodes.dto;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.domain.Ride;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
public class DTOTranslator {

    public DriverDTO translateDriverToDTO(Driver driver) {
        List<String> rides = driver.getRides().stream()
                .map(ride -> ride.toString())
                .collect(toList());
        return new DriverDTO(
                driver.getId(),
                driver.getUsername(),
                driver.getTypeOfCar(),
                rides);
    }

    public RideDTO translateRideToDTO(Ride ride) {
        return new RideDTO(
                ride.getId(),
                ride.getCustomerUsername(),
                ride.getDriver().getUsername(),
                ride.getDistance(),
                ride.getPrice());
    }
}
