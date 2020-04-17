package academy.everyonecodes.twitter.repository;

import academy.everyonecodes.twitter.data.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    List<Tweet> findByOrderByTimestampDesc();
    List<Tweet> findByUserOrderByTimestampDesc(String user);

}