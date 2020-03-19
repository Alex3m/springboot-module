package academy.everyonecodes.threepwoodcinema;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {
    private final TemplateMessageFinder templateMessageFinder;

    public TemplateEngine(TemplateMessageFinder templateMessageFinder) {
        this.templateMessageFinder = templateMessageFinder;
    }

    public String customiseMessage(String customerName) {
        String templateNameHolder = "--name--";
        String correctTemplateMessage = templateMessageFinder.find(customerName);
        String customisedMessage = correctTemplateMessage.replace(templateNameHolder, customerName);
        return customisedMessage;
    }
}
