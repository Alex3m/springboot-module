package academy.everyonecodes.service;

import org.springframework.stereotype.Service;

@Service
public class InteractionsCounter {
    private int interactions;

    public int get() {
        return interactions;
    }

    public void increaseByOne() {
        interactions = interactions + 1;
    }

    public void increaseByAmount(int amount) {
        interactions = interactions + amount;
    }
}
