package academy.everyonecodes.calculator.calculator1;

import academy.everyonecodes.calculator.calculator1.calculations.Calculation;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Calculator {
    private final ExpressionParser expressionParser;
    private final Set<Calculation> calculations;

    public Calculator(ExpressionParser expressionParser, Set<Calculation> calculations) {
        this.expressionParser = expressionParser;
        this.calculations = calculations;
    }

    public Double calculate(String expressionAsText) throws IllegalArgumentException {
        Expression expression = expressionParser.parse(expressionAsText);
        return calculations.stream()
                .filter(calculation -> calculation.matches(expression))
                .map(calculation -> calculation.calculate(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
