package academy.everyonecodes.fizzbuzz.fizzbuzz1;

import java.util.List;

public class FizzBuzz {
    private List<MultipleFinder> multipleFinders;

    public FizzBuzz(List<MultipleFinder> multipleFinders) {
        this.multipleFinders = multipleFinders;
    }

    public FizzBuzz() {
    }

    public String apply(int number) {
        return multipleFinders.stream()
                .filter(multipleFinder -> multipleFinder.isMultiple(number))
                .map(word -> word.getWordForMultiple())
                .reduce((word1, word2) -> word1 + word2)
                .orElse(String.valueOf(number));
    }
}