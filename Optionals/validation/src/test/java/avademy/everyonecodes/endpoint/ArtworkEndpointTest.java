package avademy.everyonecodes.endpoint;

import avademy.everyonecodes.domain.Artwork;
import avademy.everyonecodes.domain.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ArtworkEndpoint.class)
class ArtworkEndpointTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenNameIsInvalid_thenReturnsStatus400() throws Exception {
        Artwork invalidInput = new Artwork("name", new Rating(6));
        String body = objectMapper.writeValueAsString(invalidInput);

        mvc.perform(post("/artworks")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }
}
