package academy.everyonecodes.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DorothyTest {
    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    @Value("${urls.wizardurl}")
    String wizardUrl;

    @Test
    void homeAnswer() {

        Mockito.when(restTemplate.getForObject(wizardUrl, String.class))
                .thenReturn("answer");
        dorothy.homeAnswer();
        Mockito.verify(restTemplate).getForObject(wizardUrl, String.class);
        String wizardUrlAnswer = restTemplate.getForObject(wizardUrl, String.class);
        Mockito.verify(restTemplate).getForObject(wizardUrlAnswer, String.class);
    }
}