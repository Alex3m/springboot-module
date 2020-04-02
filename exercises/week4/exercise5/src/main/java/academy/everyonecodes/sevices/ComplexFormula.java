package academy.everyonecodes.sevices;

import academy.everyonecodes.clients.FormulaClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

@Service
public class ComplexFormula {
    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }

    public String calculate(int number) {
        String[] digitsAsText = String.valueOf(number).split("");
        return Arrays.stream(digitsAsText)
                .map(Integer::valueOf)
                .map(formulaClient::post)
                .map(String::valueOf)
                .collect(joining());
    }
}
