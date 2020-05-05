package academy.everyonecodes.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@EnableAsync
public class Scheduler {
    private final String fixedDelayMessage;
    private final String fixedRateMessage;
    private final String cronMessage;

    public Scheduler(@Value("${messages.fixed-delay}") String fixedDelayMessage,
                     @Value("${messages.fixed-rate}") String fixedRateMessage,
                     @Value("${messages.cron-message}") String cronMessage) {
        this.fixedDelayMessage = fixedDelayMessage;
        this.fixedRateMessage = fixedRateMessage;
        this.cronMessage = cronMessage;
    }

    @Async
    @Scheduled(fixedDelayString = "${intervals.fixed-delay}")
    public void displayFixedDelayMessage() {
        System.out.println(fixedDelayMessage);
    }

    @Async
    @Scheduled(fixedRateString = "${intervals.fixed-rate}")
    public void displayFixedRateMessage() {
        System.out.println(fixedRateMessage);
    }

    @Async
    @Scheduled(cron = "${intervals.cron}")
    public void displayCronMessage() {
        System.out.println(cronMessage);
    }
}
