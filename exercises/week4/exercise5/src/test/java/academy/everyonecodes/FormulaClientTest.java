package academy.everyonecodes;

import academy.everyonecodes.clients.FormulaClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class FormulaClientTest {
    @Autowired
    FormulaClient formulaClient;
    @MockBean
    RestTemplate restTemplate;
    @Value("${urls.formula}")
    String url;

    int number = 1;
    int result = 2;

    @Test
    void calculate() {
        when(restTemplate.postForObject(url, number, Integer.class))
                .thenReturn(result);
        formulaClient.post(number);
        verify(restTemplate).postForObject(url, number, Integer.class);
    }
}