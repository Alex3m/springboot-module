package academy.everyonecodes.restauranttaxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillCalculator {
    private Set<Taxer> taxers;

    public BillCalculator(BeverageTaxer beverageTaxer, FoodstuffTaxer foodstuffTaxer) {
        taxers = Set.of(beverageTaxer, foodstuffTaxer);
    }

    public double calculate(List<RestaurantDish> dishes) {
        double sumIncludingTaxes = 0;
        for (Taxer taxer : taxers) {
            sumIncludingTaxes += dishes.stream()
                    .filter(dish -> taxer.matches(dish))
                    .mapToDouble(dish -> taxer.tax(dish))
                    .sum();
        }
        return sumIncludingTaxes;
    }
}
