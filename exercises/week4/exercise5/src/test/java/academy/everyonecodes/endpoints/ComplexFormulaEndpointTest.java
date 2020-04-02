package academy.everyonecodes.endpoints;

import academy.everyonecodes.clients.FormulaClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ComplexFormulaEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    FormulaClient formulaClient;

    String url = "/complexformula";

    @Test
    void get() {
        restTemplate.getForObject(url+"/1", int.class);
        Mockito.verify(formulaClient).post(1);
    }
}