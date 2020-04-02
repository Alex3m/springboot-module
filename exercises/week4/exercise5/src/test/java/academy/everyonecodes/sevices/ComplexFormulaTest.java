package academy.everyonecodes.sevices;

import academy.everyonecodes.clients.FormulaClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ComplexFormulaTest {
    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;


    int number = 1;
    @Test
    void calculate() {
        Mockito.when(formulaClient.post(number))
                .thenReturn(number);
        complexFormula.calculate(number);
        Mockito.verify(formulaClient).post(number);
    }
}