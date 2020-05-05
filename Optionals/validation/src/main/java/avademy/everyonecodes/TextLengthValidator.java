package avademy.everyonecodes;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
@Service
@Validated
public class TextLengthValidator {

    @Length(min = 3, message = "your text can't be less than 3 character long")
    private String text;

    public void setText(@Valid String text) {
        this.text = text;
    }
}
