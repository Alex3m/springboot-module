package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.data.User;
import academy.everyonecodes.users.logic.UserStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    UserStore userStore;

    String url = "/users";

    private static Stream<Arguments> parameters() {
        User userOne = new User("name", "mail@email", "standard account");
        User newUser = new User("", "", "standard account");
        return Stream.of(
                Arguments.of(userOne, "mail@email", Optional.of(userOne)),
                Arguments.of(newUser, "unknown@email", Optional.empty())

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void getUser(User expected, String input, Optional<User> oOutput) {
        when(userStore.findUser(input))
                .thenReturn(oOutput);

        User result = restTemplate.getForObject(url + "/" + input, User.class);
        verify(userStore).findUser(input);
        Assertions.assertEquals(expected, result);
    }
}