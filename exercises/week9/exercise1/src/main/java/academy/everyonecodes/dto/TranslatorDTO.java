package academy.everyonecodes.dto;

import academy.everyonecodes.domain.Driver;
import org.springframework.stereotype.Service;

@Service
public class TranslatorDTO {

    public DriverDTO translateToDTOFrom(Driver driver) {
        return new DriverDTO(driver.getUsername(), driver.getTypeOfCar(), driver.getAuthorities(), driver.isAvailable());
    }
}

