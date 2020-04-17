package academy.everyonecodes.logic;

import academy.everyonecodes.data.PunchCard;
import academy.everyonecodes.repository.PunchCardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PunchCardService {
    private final PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    public PunchCard applyTimeStamp() {
        PunchCard currentPunchCard = getPunchCard();
        punchCardRepository.save(currentPunchCard);
        System.out.println("This punch card was saved with time stamp :" + currentPunchCard);
        return currentPunchCard;
    }

    private PunchCard getPunchCard() {
        String dayOfWeek = LocalDate.now().getDayOfWeek().toString();
        String timeOfDay = LocalTime.now().toString();
        return new PunchCard(dayOfWeek, timeOfDay);
    }
}
