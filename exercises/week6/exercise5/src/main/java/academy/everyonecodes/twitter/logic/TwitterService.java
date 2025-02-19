package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.data.Tweet;
import academy.everyonecodes.twitter.repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {
    private final TweetRepository tweetRepository;

    public TwitterService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getAll() {
        return tweetRepository.findByOrderByTimestampDesc();
    }

    public List<Tweet> getTweetsFromUser(String user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet postTweet(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        tweetRepository.save(tweet);
        return tweet;
    }

    public Optional<Tweet> likeTheTweet(String id) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        oTweet.ifPresent(tweet -> {
            int likes = tweet.getLikes();
            tweet.setLikes(likes + 1);
            tweetRepository.save(tweet);
        });
        return oTweet;
    }

    public Optional<Tweet> commentOnTweet(String id, String comment) {
        Optional<Tweet> oTweet = tweetRepository.findById(id);
        oTweet.ifPresent(tweet -> {
            tweet.getComments().add(comment);
            tweetRepository.save(tweet);
        });
        return oTweet;
    }
}
