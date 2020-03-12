package academy.everyonecodes.fizzbuzz.fizzbuzz1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFinderConfiguration {

    @Bean
    MultipleFinder multipleOfThree() {
        return new MultipleFinder(3, "Fizz");
    }

    @Bean
    MultipleFinder multipleOfFive() {
        return new MultipleFinder(5, "Buzz");
    }
}
