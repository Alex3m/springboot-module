package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Driver;
import academy.everyonecodes.dto.DriverDTO;
import academy.everyonecodes.dto.TranslatorDTO;
import academy.everyonecodes.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {
    private final PasswordEncoder encoder;
    private final DriverRepository repository;
    private final TranslatorDTO translatorDTO;
    private final Set<String> authorities;


    public DriverService(PasswordEncoder encoder, DriverRepository repository, TranslatorDTO translatorDTO,
                         @Value("${drivers.authorities}") Set<String> authorities) {
        this.encoder = encoder;
        this.repository = repository;
        this.translatorDTO = translatorDTO;
        this.authorities = authorities;
    }

    public Driver saveDriver(Driver driver) {
        if (repository.existsByUsername(driver.getUsername())) {
            return driver;
        }
        driver.setAuthorities(authorities);
        return setAndSaveDriver(driver);
    }

    public Optional<DriverDTO> getDriverBy(String id) {
        Optional<Driver> optionalDriver = repository.findById(id);
        if (optionalDriver.isPresent()) {
            DriverDTO driverDTO = translatorDTO.translateToDTOFrom(optionalDriver.get());
            return Optional.of(driverDTO);
        }
        return Optional.empty();
    }

    public void makeAvailable(String id) {
        Optional<Driver> oDriver = repository.findById(id);
        oDriver.ifPresent(driver -> setAvailability(driver, true));
    }

    public void makeUnAvailable(String id) {
        Optional<Driver> oDriver = repository.findById(id);
        oDriver.ifPresent(driver -> setAvailability(driver, false));
    }

    private void setAvailability(Driver driver, boolean isAvailable) {
        driver.setAvailable(isAvailable);
        repository.save(driver);
    }

    Driver setAndSaveDriver(Driver driver) {
        String password = driver.getPassword();
        String encodedPassword = encoder.encode(password);
        driver.setPassword(encodedPassword);
        return repository.save(driver);
    }
}
