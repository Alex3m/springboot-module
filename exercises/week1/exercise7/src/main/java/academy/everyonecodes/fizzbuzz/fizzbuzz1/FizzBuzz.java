package academy.everyonecodes.fizzbuzz.fizzbuzz1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FizzBuzz {
    private List<MultipleFinder> multipleFinders;

    public FizzBuzz(List<MultipleFinder> multipleFinders) {
        this.multipleFinders = multipleFinders;
    }

    public FizzBuzz() {
    }

    public String apply(int number) {
        String result = multipleFinders.stream()
                .filter(multipleFinder -> multipleFinder.isMultiple(number))
                .map(word -> word.getWordForMultiple())
                .collect(Collectors.joining());
        if(result.isBlank()){
            return String.valueOf(number);
        }
        return result;
    }
}
