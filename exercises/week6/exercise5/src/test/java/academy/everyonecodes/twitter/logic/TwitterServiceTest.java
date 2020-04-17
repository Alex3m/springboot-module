package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.data.Tweet;
import academy.everyonecodes.twitter.repository.TweetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TwitterServiceTest {
    @Autowired
    TwitterService service;

    @MockBean
    TweetRepository repository;
    String user = "testUser";
    String id = "testId";
    String comment = "comment";
    Tweet testTweet = new Tweet(user, "testText", 0);
    List<String> comments = new ArrayList<>(List.of(comment));

    @Test
    void getAll() {
        service.getAll();
        verify(repository).findByOrderByTimestampDesc();
    }

    @Test
    void getTweetsFromUser() {
        service.getTweetsFromUser(user);
        verify(repository).findByUserOrderByTimestampDesc(user);
    }

    @Test
    void postTweet() {

        Tweet result = service.postTweet(testTweet);
        verify(repository).save(testTweet);
        Assertions.assertNotNull(result.getTimestamp());
    }

    @Test
    void likeTheTweet() {
        Tweet expected = new Tweet(user, "testText", 1);

        when(repository.findById(id))
                .thenReturn(Optional.of(testTweet));

        Optional<Tweet> oResult = service.likeTheTweet(id);
        Tweet result = oResult.get();

        verify(repository).save(testTweet);
        Assertions.assertTrue(oResult.isPresent());
        Assertions.assertEquals(expected, result);
    }

    @Test
    void commentOnTweet() {
        Tweet expected = testTweet;
        expected.setComments(comments);

        when(repository.findById(id))
                .thenReturn(Optional.of(testTweet));

        Optional<Tweet> oResult = service.commentOnTweet(id, comment);
        Assertions.assertTrue(oResult.isPresent());
        Assertions.assertEquals(expected, oResult.get());
    }
}