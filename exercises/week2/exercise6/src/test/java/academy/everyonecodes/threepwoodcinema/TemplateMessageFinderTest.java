package academy.everyonecodes.threepwoodcinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateMessageFinderTest {
    @Autowired
    TemplateMessageFinder templateMessageFinder;

    @ParameterizedTest
    @CsvSource({
            "'Good day --name--, don’t forget our 20% discount on tickets this Friday!', 'Mr. Sanders' ",
            "'My dearest --name--, your lovely family gives you a 20% discount on tickets this Friday!', 'Ms. Threepwood'",
            "'Dear --name--, you and your friends will have so much fun at the cinema this Friday with a 20% discount!', 'Ms. Jessica'",
            "'Hello --name--! How about a Friday night movie? This week with a 20% discount!', 'Carter'",
            "'Hello --name--! How about a Friday night movie? This week with a 20% discount!', ''"

    })
    void find(String expected, String input) {
        String result = templateMessageFinder.find(input);

        Assertions.assertEquals(expected, result);


    }
}