package academy.everyonecodes.dto;

import academy.everyonecodes.domain.Driver;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslatorDTOTest {
    TranslatorDTO translatorDTO = new TranslatorDTO();
    Driver input = new Driver("test", "testPass", "TestCar", Set.of("ROLE_DRIVER"));
    DriverDTO expectedDTO = new DriverDTO("test", "TestCar", Set.of("ROLE_DRIVER"), false);

    @Test
    void translateToDTOFrom() {
        DriverDTO result = translatorDTO.translateToDTOFrom(input);
        assertEquals(expectedDTO, result);
    }
}