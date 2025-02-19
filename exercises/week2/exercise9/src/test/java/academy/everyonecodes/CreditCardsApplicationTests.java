package academy.everyonecodes;

import academy.everyonecodes.app.CreditCards;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreditCardsApplicationTests {
    @Autowired
    CreditCards creditCards;

    @ParameterizedTest
    @CsvSource({
            "Invalid, 37828224631000",
            "MasterCard, 5555555555554444",
            "American Express, 378282246310005",
            "Visa, 4111111111111111",
            "Discover, 6011111111111117",
            "Not Supported, 5610591081018250"

    })
    void contextLoads(String expected, String input) {
        String result = creditCards.inspect(input);
        assertEquals(expected, result);
    }

}
