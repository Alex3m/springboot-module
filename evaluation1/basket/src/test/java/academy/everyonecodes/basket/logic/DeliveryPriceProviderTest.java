package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.client.UsersClient;
import academy.everyonecodes.basket.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DeliveryPriceProviderTest {
    @Autowired
    DeliveryPriceProvider deliveryPriceProvider;
    @MockBean
    UsersClient client;

    private static Stream<Arguments> parameters() {
        User premiumUser = new User("test1", "premium account");
        User standardUser = new User("test2", "standard account");
        return Stream.of(
                Arguments.of(0.0, "test1", premiumUser),
                Arguments.of(2.5, "test2", standardUser)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void get(double expected, String input, User mockOutput) {
        when(client.getUser(input))
                .thenReturn(mockOutput);
        double result = deliveryPriceProvider.get(input);
        Assertions.assertEquals(expected, result);
    }
}