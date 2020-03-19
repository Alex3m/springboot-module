package academy.everyonecodes.restauranttaxer;

import java.util.List;

public abstract class Taxer {
    private List<String> names;
    private double tax;

    public Taxer(List<String> names, double tax) {
        this.names = names;
        this.tax = tax;
    }

    public boolean matches(RestaurantDish restaurantDish){
        return names.contains(restaurantDish.getName());
    }
    public double tax (RestaurantDish restaurantDish){
        return restaurantDish.getPrice()+tax;
    }

}
