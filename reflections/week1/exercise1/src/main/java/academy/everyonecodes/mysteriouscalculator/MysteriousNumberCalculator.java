package academy.everyonecodes.mysteriouscalculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MysteriousNumberCalculator {
    private Set<MysteriousAddition> mysteriousAdditions;
    private MysteriousNumberFormatter mysteriousNumberFormatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> mysteriousAdditions, MysteriousNumberFormatter mysteriousNumberFormatter) {
        this.mysteriousAdditions = mysteriousAdditions;
        this.mysteriousNumberFormatter = mysteriousNumberFormatter;
    }

    public String calculate(int number) {
        int result = mysteriousAdditions.stream()
                .map(mysteriousAddition -> mysteriousAddition.apply(number))
                .reduce(0, (numberOne, numberTwo) -> numberTwo + numberOne) - number;

        return mysteriousNumberFormatter.format(result);
    }
}
