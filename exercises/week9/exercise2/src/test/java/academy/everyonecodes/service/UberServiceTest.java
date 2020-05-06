package academy.everyonecodes.service;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.domain.Ride;
import academy.everyonecodes.dto.DTOTranslator;
import academy.everyonecodes.dto.DriverDTO;
import academy.everyonecodes.dto.RideDTO;
import academy.everyonecodes.repository.DriverRepository;
import academy.everyonecodes.repository.RideRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UberServiceTest {
    @Autowired
    UberService uberService;

    @MockBean
    DriverRepository driverRepository;
    @MockBean
    RideRepository rideRepository;
    @MockBean
    DTOTranslator dtoTranslator;

    Driver driver = new Driver("test", "test", "testCar");
    DriverDTO driverDTO = new DriverDTO(1L,"test", "test", List.of("testRide"));
    Ride ride = new Ride("nameTest", 5, 5);
    RideDTO rideDTO = new RideDTO(1L,"nameTest", "test", 5, 5);

    @Test
    void save() {
        uberService.save(driver);
        verify(driverRepository).save(driver);
    }

    @Test
    void getAll() {
        uberService.getAll();
        verify(driverRepository).findAll();
    }

    @Test
    void saveAndLink() {
        Long id = 12L;
        when(driverRepository.existsById(id))
                .thenReturn(true);
        when(driverRepository.findById(id))
                .thenReturn(Optional.of(driver));
        when(rideRepository.save(ride))
                .thenReturn(ride);
        when(driverRepository.save(driver))
                .thenReturn(driver);
        when(dtoTranslator.translateRideToDTO(ride))
                .thenReturn(rideDTO);
        uberService.saveAndLink(ride, id);
        verify(driverRepository).existsById(id);
        verify(driverRepository).findById(id);
        verify(rideRepository).save(ride);
        verify(driverRepository).save(driver);
        verify(dtoTranslator).translateRideToDTO(ride);

    }
}