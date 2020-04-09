package academy.everyonecodes.users.endpoint;

import academy.everyonecodes.users.data.User;
import academy.everyonecodes.users.logic.UserStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserStore userStore;

    public UserEndpoint(UserStore userStore) {
        this.userStore = userStore;
    }

    @GetMapping("/{email}")
    User getUser(@PathVariable String email) {
        return userStore.findUser(email).orElse(new User("", "", "standard account"));
    }
}
