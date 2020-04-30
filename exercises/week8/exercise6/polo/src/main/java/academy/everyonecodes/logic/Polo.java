package academy.everyonecodes.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Polo {
    private String expectedMessage;
    private String answerForExpected;
    private String answerForElse;

    public Polo(@Value("${messages.expected}") String expectedMessage,
                @Value("${messages.answer-for-expected}") String answerForExpected,
                @Value("${messages.answer-for-else}") String answerForElse) {
        this.expectedMessage = expectedMessage;
        this.answerForExpected = answerForExpected;
        this.answerForElse = answerForElse;
    }

    public String answer(String message) {
        if (message.equals(expectedMessage)) {
            return answerForExpected;
        }
        return answerForElse;
    }
}
