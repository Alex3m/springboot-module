package academy.everyonecodes.fizzbuzz.fizzbuzz1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FizzBuzzConfiguration {
    @Bean
    FizzBuzz fizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive){
        return new FizzBuzz(List.of(multipleOfThree, multipleOfFive));
    }
}
