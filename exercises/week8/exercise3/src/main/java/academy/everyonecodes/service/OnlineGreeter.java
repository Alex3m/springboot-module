package academy.everyonecodes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OnlineGreeter {
    private final String landing;
    private final String userFirstEntry;
    private final String german;
    private final String english;

    public OnlineGreeter(@Value("${school.messages.landing}") String landing,
                         @Value("${school.messages.userfirstentry}") String userFirstEntry,
                         @Value("${school.messages.german}") String german,
                         @Value("${school.messages.english}") String english) {
        this.landing = landing;
        this.userFirstEntry = userFirstEntry;
        this.german = german;
        this.english = english;
    }
    public String getLandingPageMessage(){
        return landing;
    }
    public String getUserFirstEntry(){
        return userFirstEntry;
    }

    public String getGerman() {
        return german;
    }

    public String getEnglish() {
        return english;
    }
}
