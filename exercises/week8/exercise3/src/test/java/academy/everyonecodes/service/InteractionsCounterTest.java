package academy.everyonecodes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class InteractionsCounterTest {
    InteractionsCounter counter;

    @BeforeEach
    void setup() {
        counter = new InteractionsCounter();
    }

    @Test
    void increaseByOne() {
        int expected = 1;
        counter.increaseByOne();
        int result = counter.get();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void increaseByAmount() {
        int amount = 100;
        counter.increaseByAmount(amount);
        int result = counter.get();
        Assertions.assertEquals(amount, result);
    }
}