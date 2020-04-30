package academy.everyonecodes.logic;

import academy.everyonecodes.domain.Member;
import academy.everyonecodes.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MysteriousOrderCoordinator {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;
    private final String message;

    public MysteriousOrderCoordinator(MemberRepository repository,
                                      @Value("${order.welcome-message}") String message, PasswordEncoder encoder) {
        this.repository = repository;
        this.message = message;
        this.encoder = encoder;
    }

    public String getMessage() {
        return message;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Set<Member> getAllByAuthority(String authority) {
        return repository.findAllByAuthorities(authority);
    }

    public Member saveMember(Member member) {
        if (repository.existsByUsername(member.getUsername())) {
            return member;
        }
        member.setPassword(encoder.encode(member.getPassword()));
        return repository.save(member);
    }
}
