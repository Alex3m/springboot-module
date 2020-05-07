package academy.everyonecodes.logic;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repository.SteamUserRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("steam")
public class ManagerInitializer {

    private SteamUser manager;
    private final PasswordEncoder encoder;
    private final SteamUserRepository repository;

    public ManagerInitializer(PasswordEncoder encoder, SteamUserRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    public void setManager(SteamUser manager) {
        this.manager = manager;
    }

    public void initialize() {
        if (repository.existsByUsername(manager.getUsername())) {
            return;
        }
        String encodedPassword = encoder.encode(manager.getPassword());
        manager.setPassword(encodedPassword);
        repository.save(manager);
    }
}
