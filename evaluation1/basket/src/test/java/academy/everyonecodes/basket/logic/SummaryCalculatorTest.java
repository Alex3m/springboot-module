package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.data.ItemSelection;
import academy.everyonecodes.basket.data.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class SummaryCalculatorTest {
    @Autowired
    SummaryCalculator calculator;

    @MockBean
    DeliveryPriceProvider deliveryPriceProvider;

    String email = "test@mail";
    ItemSelection itemSelection = new ItemSelection(email, "test", 1.0);
    Summary expected = new Summary(email, "test", 1.0, 2.0, 3.0);


    @Test
    void calculate() {
        Mockito.when(deliveryPriceProvider.get(email))
                .thenReturn(2.0);
        Summary result = calculator.calculate(itemSelection);
        Assertions.assertEquals(expected, result);
    }
}