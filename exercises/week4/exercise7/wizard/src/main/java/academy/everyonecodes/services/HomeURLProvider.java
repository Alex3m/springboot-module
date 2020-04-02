package academy.everyonecodes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeURLProvider {
    private String url;

    public HomeURLProvider(@Value("${home.url}") String url) {
        this.url = url;
    }

    public String getHomeURL() {
        return url;
    }
}
