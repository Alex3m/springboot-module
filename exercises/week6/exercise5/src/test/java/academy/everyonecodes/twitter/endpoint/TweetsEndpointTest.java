package academy.everyonecodes.twitter.endpoint;

import academy.everyonecodes.twitter.data.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    TwitterService service;

    String url = "/tweets/";
    String user = "test";
    String id = "test";
    Tweet tweet = new Tweet("testUser", "test", 1);
    String comment = "testComment";

    @Test
    void getTweets() {
        restTemplate.getForObject(url, List.class);
        verify(service).getAll();
    }

    @Test
    void getOneUserTweets() {
        restTemplate.getForObject(url + "user/" + user, List.class);
        verify(service).getTweetsFromUser(user);
    }

    @Test
    void postTweet() {
        restTemplate.postForObject(url, tweet, Tweet.class);
        verify(service).postTweet(tweet);
    }

    @Test
    void putLikeOnTweet() {
        restTemplate.put(url + id + "/likes", void.class);
        verify(service).likeTheTweet(id);
    }

    @Test
    void commentTweet() {
        restTemplate.put(url + id + "/comments", comment, String.class);
        verify(service).commentOnTweet(id, comment);
    }
}