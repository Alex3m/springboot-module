package academy.everyonecodes.endpoint;

import academy.everyonecodes.logic.TreatmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TreatmentEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TreatmentService service;

    String url = "/treatments";
    String uuid = "testUuid";

    @Test
    void getAllTreatments() {
        restTemplate.getForObject(url, List.class);
        verify(service).getAllTreatments();
    }

    @Test
    void getTreatmentsForUuid() {
        restTemplate.getForObject(url + "/" + uuid, List.class);
        verify(service).getTreatmentByUuid(uuid);
    }
}