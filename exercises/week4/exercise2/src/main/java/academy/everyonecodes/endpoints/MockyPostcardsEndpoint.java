package academy.everyonecodes.endpoints;

import academy.everyonecodes.clients.MockyPostcardsClient;
import academy.everyonecodes.data.Postcard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {
    private final MockyPostcardsClient postcardsClient;

    public MockyPostcardsEndpoint(MockyPostcardsClient postcardsClient) {
        this.postcardsClient = postcardsClient;
    }

    @GetMapping("/1")
    Postcard getPostcard() {
        return postcardsClient.getPostcard();
    }

    @GetMapping("/2")
    List<Postcard> getPostcardList() {
        return postcardsClient.getPostcardList();
    }
}
