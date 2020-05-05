package avademy.everyonecodes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolationException;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@Validated
class TextLengthValidatorTest {
    TextLengthValidator textLengthValidator = new TextLengthValidator();

    @Test
    void validateThrows() {
        String input = "no";
        Assertions.assertThrows(ConstraintViolationException.class, () ->
                textLengthValidator.setText(input));
    }
    @Test
    void validateDoesntThrows() {
        String input = "yes";
        Assertions.assertDoesNotThrow(() ->
                textLengthValidator.setText(input));
    }
}