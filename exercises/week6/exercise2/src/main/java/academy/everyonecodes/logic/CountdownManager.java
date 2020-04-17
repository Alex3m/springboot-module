package academy.everyonecodes.logic;

import academy.everyonecodes.data.Countdown;
import academy.everyonecodes.repository.CountdownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountdownManager {
    private final CountdownRepository repository;
    private final AccumulationManager accumulationManager;

    public CountdownManager(CountdownRepository repository, AccumulationManager accumulationManager) {
        this.repository = repository;
        this.accumulationManager = accumulationManager;
    }

    public Optional<Countdown> getUpdatedCountdown() {
        List<Countdown> countdownList = repository.findAll();
        Optional<Countdown> optionalCountdown = Optional.empty();
        if (countdownList.isEmpty()) {
            optionalCountdown = Optional.of(new Countdown(3));
        }
        if (countdownList.get(0).getCount() > 0) {
            Countdown currentCountdown = countdownList.get(0);
            int currentCount = currentCountdown.getCount();
            currentCountdown.setCount(currentCount - 1);
            optionalCountdown = Optional.of(currentCountdown);
        }
        return optionalCountdown;
    }

    public Optional<Countdown> updateCountdownRepository() {
        Optional<Countdown> optionalCountdown = getUpdatedCountdown();
        optionalCountdown.ifPresentOrElse(repository::save, repository::deleteAll);
        optionalCountdown.ifPresent(countdown ->
                System.out.println("Countdown: " + countdown.getCount()
                ));
        accumulationManager.accumulate(optionalCountdown);
        return optionalCountdown;
    }

}
