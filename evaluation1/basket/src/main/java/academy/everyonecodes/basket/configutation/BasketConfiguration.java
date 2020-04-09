package academy.everyonecodes.basket.configutation;

import academy.everyonecodes.basket.logic.Basket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketConfiguration {

    @Bean
    Basket basket() {
        return new Basket();
    }
}
