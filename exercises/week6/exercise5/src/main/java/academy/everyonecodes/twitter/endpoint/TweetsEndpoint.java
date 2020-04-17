package academy.everyonecodes.twitter.endpoint;

import academy.everyonecodes.twitter.data.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {
    private final TwitterService service;

    public TweetsEndpoint(TwitterService service) {
        this.service = service;
    }

    @GetMapping
    List<Tweet> getTweets() {
        return service.getAll();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getOneUserTweets(@PathVariable String user) {
        return service.getTweetsFromUser(user);
    }

    @PostMapping
    Tweet postTweet(@RequestBody Tweet tweet) {
        return service.postTweet(tweet);
    }

    @PutMapping("/{id}/likes")
    void putLikeOnTweet(@PathVariable String id) {
        service.likeTheTweet(id);
    }

    @PutMapping("/{id}/comments")
    String commentTweet(@PathVariable String id, @RequestBody String comment) {
        service.commentOnTweet(id, comment);
        return comment;
    }

}
