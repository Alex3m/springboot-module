package academy.everyonecodes.endpoints;

import academy.everyonecodes.clients.MockyTextClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocky/texts")

public class MockyTextsEndpoint {
    private MockyTextClient textClient;

    public MockyTextsEndpoint(MockyTextClient textClient) {
        this.textClient = textClient;
    }

    @GetMapping("/1")
    String getText() {
        return textClient.getText();
    }

    @GetMapping("/2")
    String[] getArray() {
        return textClient.getArray();
    }
}
