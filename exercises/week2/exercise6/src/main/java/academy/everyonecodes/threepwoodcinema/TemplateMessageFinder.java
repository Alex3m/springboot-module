package academy.everyonecodes.threepwoodcinema;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("cinema.specialoffer")
public class TemplateMessageFinder {
    private final List<Template> templates;
    private String defaultMessage;


    public TemplateMessageFinder(List<Template> templates) {
        this.templates = templates;
    }

    void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String find(String customerName) {
        return templates.stream()
                .filter(template -> customerName.contains(template.getKeyword()))
                .map(template -> template.getMessage())
                .findFirst()
                .orElse(defaultMessage);
    }
}
