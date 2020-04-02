package academy.everyonecodes.endpoints;

import academy.everyonecodes.client.LoremIpsumClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class LoremIpsumEndpoint {
    private final LoremIpsumClient loremIpsumClient;

    public LoremIpsumEndpoint(LoremIpsumClient loremIpsumClient) {
        this.loremIpsumClient = loremIpsumClient;
    }

    @GetMapping("/loremipsum")
    public String getLoremIpsumText() {
        return loremIpsumClient.getText();
    }
}
