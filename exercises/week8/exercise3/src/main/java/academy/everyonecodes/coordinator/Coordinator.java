package academy.everyonecodes.coordinator;

import academy.everyonecodes.service.InteractionsCounter;
import academy.everyonecodes.service.OnlineGreeter;
import org.springframework.stereotype.Service;

@Service
public class Coordinator {
    private final InteractionsCounter interactionsCounter;
    private final OnlineGreeter greeter;

    public Coordinator(InteractionsCounter interactionsCounter, OnlineGreeter greeter) {
        this.interactionsCounter = interactionsCounter;
        this.greeter = greeter;
    }

    public String getLandingPageMessage() {
        interactionsCounter.increaseByOne();
        return greeter.getLandingPageMessage();
    }

    public String getUserFirstEntry() {
        interactionsCounter.increaseByOne();
        return greeter.getUserFirstEntry();
    }

    public String getGerman() {
        interactionsCounter.increaseByOne();
        return greeter.getGerman();
    }

    public String getEnglish() {
        interactionsCounter.increaseByOne();
        return greeter.getEnglish();
    }

    public int getInteractionsCount() {
        return interactionsCounter.get();
    }
}
