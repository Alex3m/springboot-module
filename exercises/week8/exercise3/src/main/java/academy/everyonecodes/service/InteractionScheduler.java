package academy.everyonecodes.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class InteractionScheduler {
    private final InteractionsCounter counter;
    private final int amount;

    public InteractionScheduler(InteractionsCounter counter,
                                @Value("${counter.amount}") int amount) {
        this.counter = counter;
        this.amount = amount;
    }
    @Scheduled(fixedDelayString = "${counter.interval}")
    public void addInteractions() {
        counter.increaseByAmount(amount);
    }

}
