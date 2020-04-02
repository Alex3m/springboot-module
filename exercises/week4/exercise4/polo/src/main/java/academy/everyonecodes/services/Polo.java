package academy.everyonecodes.services;

import org.springframework.stereotype.Service;

@Service
public class Polo {
    public String answering(String text) {
        if (text.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
