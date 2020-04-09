package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.data.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@ConfigurationProperties("accounts")
public class UserStore {
    private Set<User> users;

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Optional<User> findUser(String userEmail) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(userEmail))
                .findFirst();
    }
}

