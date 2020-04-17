package academy.everyonecodes.logic;

import academy.everyonecodes.data.Accumulation;
import academy.everyonecodes.data.Countdown;
import academy.everyonecodes.repository.AccumulationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccumulationManager {
    private final AccumulationRepository repository;

    public AccumulationManager(AccumulationRepository repository) {
        this.repository = repository;
    }

    public Accumulation accumulate(Optional<Countdown> optionalCountdown) {
        Accumulation accumulation = new Accumulation(1);
        if (optionalCountdown.isEmpty()) {
            List<Accumulation> accumulations = repository.findAll();
            if (accumulations.isEmpty()) {
                repository.save(accumulation);
                System.out.println("Times that the countdown went off: " + accumulation.getTimes());
                return accumulation;
            }
            accumulation = accumulations.get(0);
            int newAccumulationTimes = accumulation.getTimes() + 1;
            accumulation.setTimes(newAccumulationTimes);
            repository.save(accumulation);
            System.out.println("Times that the countdown went off: " + newAccumulationTimes);
        }
        return accumulation;
    }

}
