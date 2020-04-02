package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.TestResult;
import academy.everyonecodes.tester.MarathonTester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarathonIntegrationEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MarathonTester marathonTester;

    String url = "/marathon/integration";

    @Test
    void getTest() {
        restTemplate.getForObject(url, TestResult.class);
        verify(marathonTester).getTested();
    }

}