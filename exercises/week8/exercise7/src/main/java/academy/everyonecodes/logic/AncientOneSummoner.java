package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Member;
import academy.everyonecodes.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AncientOneSummoner {
    private final MemberRepository repository;
    private String name;
    private String password;
    private Set<String> authorities;
    private final PasswordEncoder encoder;

    public AncientOneSummoner(@Value("${ancient-one.username}") String name,
                              @Value("${ancient-one.password}") String password,
                              @Value("${ancient-one.authorities}") Set<String> authorities, MemberRepository repository, PasswordEncoder encoder) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
        this.repository = repository;
        this.encoder = encoder;
    }

    public void summon() {
        if (repository.existsByUsername(name)) {
            return;
        }

        Member ancientOne = new Member(name, encoder.encode(password), authorities);
        repository.save(ancientOne);
    }
}
