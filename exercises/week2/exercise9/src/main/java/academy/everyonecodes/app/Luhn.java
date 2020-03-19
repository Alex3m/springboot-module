package academy.everyonecodes.app;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;

@Service
public class Luhn {
    public boolean isValid(String cardNumberAsString) {
        List<Integer> cardNumberDigits = Arrays.stream(cardNumberAsString.split(""))
                .map(Integer::valueOf)
                .collect(toList());
        reverse(cardNumberDigits);
        boolean isItForMultiplication = false;
        int sum = 0;
        for (Integer digit : cardNumberDigits) {
            if (isItForMultiplication) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = digit % 10 + 1;
                }
            }
            isItForMultiplication = !isItForMultiplication;
            sum = sum + digit;
        }
        boolean isValid = sum % 10 == 0;
        return isValid;
    }
}
