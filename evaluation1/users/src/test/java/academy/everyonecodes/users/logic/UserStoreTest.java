package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class UserStoreTest {
    @Autowired
    UserStore userStore;

    private static Stream<Arguments> parameters() {
        User userOne = new User("name1", "name1@mail", "test");
        return Stream.of(
                Arguments.of(Optional.of(userOne), "name1@mail"),
                Arguments.of(Optional.empty(), "unknown@mail")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findUser(Optional<User> oExpected, String input) {
        Optional<User> oResult = userStore.findUser(input);
        Assertions.assertEquals(oExpected, oResult);
    }
}