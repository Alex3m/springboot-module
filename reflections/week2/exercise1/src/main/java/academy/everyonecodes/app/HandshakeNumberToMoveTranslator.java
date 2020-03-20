package academy.everyonecodes.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.joining;

@Service
@ConfigurationProperties("secretagent")
public class HandshakeNumberToMoveTranslator {
    private Set<Handshake> handshakes;

    public void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public String translate(int number) {
        return handshakes.stream()
                .filter(handshake -> handshake.getNumber() == number)
                .map(handshake -> handshake.getMove())
                .collect(joining());
    }
}
