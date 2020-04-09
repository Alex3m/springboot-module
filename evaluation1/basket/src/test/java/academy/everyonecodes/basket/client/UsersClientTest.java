package academy.everyonecodes.basket.client;

import academy.everyonecodes.basket.data.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class UsersClientTest {
    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${userstore.url}")
    String url;

    String email = "test@mail";
    @Test
    void getUser() {

        usersClient.getUser(email);
        Mockito.verify(restTemplate).getForObject(url+"/"+email, User.class);
    }
}