package academy.everyonecodes.endpoint;

import academy.everyonecodes.domain.Member;
import academy.everyonecodes.logic.MysteriousOrderCoordinator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class OrderEndpoint {
    private final MysteriousOrderCoordinator coordinator;
    private final String authority;

    public OrderEndpoint(MysteriousOrderCoordinator coordinator,
                         @Value("${authority.apprentices}") String authority) {
        this.coordinator = coordinator;
        this.authority = authority;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    String get() {
        return coordinator.getMessage();
    }

    @PostMapping("/members")
    @Secured("ROLE_MASTER")
    Member postMember(@RequestBody Member member) {
        return coordinator.saveMember(member);
    }

    @GetMapping("/members")
    @Secured("ROLE_MASTER")
    List<Member> getAll() {
        return coordinator.getAllMembers();
    }

    @GetMapping("/members/apprentices")
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    Set<Member> getAllByAuthority() {
        return coordinator.getAllByAuthority(authority);
    }
}
