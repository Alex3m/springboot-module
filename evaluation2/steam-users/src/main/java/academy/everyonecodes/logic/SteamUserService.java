package academy.everyonecodes.logic;

import academy.everyonecodes.domain.SteamUser;
import academy.everyonecodes.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SteamUserService {
    private final SteamUserRepository repository;
    private final PasswordEncoder encoder;
    private final String successful;
    private final String[] userAuthorities;

    public SteamUserService(
            SteamUserRepository repository,
            PasswordEncoder encoder,
            @Value("${steam.login-message.successful}") String successful,
            @Value("${steam.user.authorities}") String[] userAuthorities) {
        this.repository = repository;
        this.encoder = encoder;
        this.successful = successful;
        this.userAuthorities = userAuthorities;
    }

    public SteamUser saveUser(SteamUser steamUser) {
        Optional<SteamUser> oUser = repository.findOneByUsername(steamUser.getUsername());
        if (oUser.isPresent()) {
            return oUser.get();
        }
        String encodedPassword = encoder.encode(steamUser.getPassword());
        steamUser.setPassword(encodedPassword);
        steamUser.setAuthorities(userAuthorities);
        return repository.save(steamUser);
    }

    public String getLoginMessage() {
        return successful;
    }
}
