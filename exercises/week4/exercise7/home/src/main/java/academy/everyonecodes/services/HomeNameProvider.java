package academy.everyonecodes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HomeNameProvider {
    private String home;

    public HomeNameProvider( @Value("${property.home}") String home) {
        this.home = home;
    }

    public String getHomeName(){
        return home;
    }
}
