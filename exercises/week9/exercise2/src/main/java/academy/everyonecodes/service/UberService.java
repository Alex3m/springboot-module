package academy.everyonecodes.service;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.domain.Ride;
import academy.everyonecodes.dto.DTOTranslator;
import academy.everyonecodes.dto.DriverDTO;
import academy.everyonecodes.dto.RideDTO;
import academy.everyonecodes.repository.DriverRepository;
import academy.everyonecodes.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class UberService {
    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;
    private final DTOTranslator dtoTranslator;

    public UberService(DriverRepository driverRepository, RideRepository rideRepository, DTOTranslator dtoTranslator) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
        this.dtoTranslator = dtoTranslator;
    }

    public Driver save(Driver driver) {
        if (driverRepository.existsByUsername(driver.getUsername())) {
            return driver;
        }
        return driverRepository.save(driver);
    }

    public List<DriverDTO> getAll() {
        return driverRepository.findAll().stream()
                .map(dtoTranslator::translateDriverToDTO)
                .collect(toList());
    }

    public RideDTO saveAndLink(Ride ride, long driverId) {
        if (!driverRepository.existsById(driverId)) {
            return dtoTranslator.translateRideToDTO(ride);
        }
        Optional<Driver> oDriver = driverRepository.findById(driverId);
        Driver driver1 = oDriver.get();
        ride.setDriver(driver1);
        Ride savedRide = rideRepository.save(ride);
        oDriver.ifPresent(driver -> driver.getRides().add(savedRide));
        oDriver.ifPresent(driverRepository::save);
        return dtoTranslator.translateRideToDTO(savedRide);
    }
}
