package academy.everyonecodes.calculator.calculator1;

import org.springframework.stereotype.Service;

@Service
public class ExpressionParser {
    public Expression parse(String expressionAsString) {
        String[] expressionArr = expressionAsString.split(" ");
        String symbol = expressionArr[1];
        double term1 = Double.parseDouble(expressionArr[0]);
        double term2 = Double.parseDouble(expressionArr[2]);

        return new Expression(symbol, term1, term2);

    }
}
