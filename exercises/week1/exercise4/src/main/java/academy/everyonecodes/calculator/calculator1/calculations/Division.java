package academy.everyonecodes.calculator.calculator1.calculations;

import academy.everyonecodes.calculator.calculator1.Expression;
import org.springframework.stereotype.Service;

@Service
public class Division extends Calculation {
    public Division() {
        super("/");
    }

    @Override
    public double calculate(Expression expression) {

        return expression.getTerm1() / expression.getTerm2();

    }
}
