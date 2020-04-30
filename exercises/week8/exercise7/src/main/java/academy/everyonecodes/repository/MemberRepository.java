package academy.everyonecodes.repository;

import academy.everyonecodes.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends MongoRepository<Member, String> {
    Set<Member> findAllByAuthorities(String authority);

    Optional<Member> findOneByUsername(String username);

    boolean existsByUsername(String username);

}
