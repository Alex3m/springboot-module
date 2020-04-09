package academy.everyonecodes.basket.endpoint;

import academy.everyonecodes.basket.data.ItemSelection;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ItemSelectionEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    SummaryCalculator summaryCalculator;

    String url = "/itemselections";
    ItemSelection itemSelection = new ItemSelection("test", "test", 1.0);

    @Test
    void post() {
        restTemplate.postForObject(url, itemSelection, ItemSelection.class);
        Mockito.verify(summaryCalculator).calculate(itemSelection);
    }
}