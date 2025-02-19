package academy.everyonecodes.calculator.calculator1.calculations;

import academy.everyonecodes.calculator.calculator1.Expression;

public abstract class Calculation {
    private String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return symbol.equals(expression.getSymbol());
    }

    public abstract double calculate(Expression expression);
}
