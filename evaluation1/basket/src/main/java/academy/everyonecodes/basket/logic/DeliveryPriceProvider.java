package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.client.UsersClient;
import academy.everyonecodes.basket.data.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPriceProvider {
    private final UsersClient usersClient;
    private final double standardDeliveryCost;
    private final double premiumDeliveryCost;

    public DeliveryPriceProvider(UsersClient usersClient,
                                 @Value("${costs.standarddeliverycost}") double standardDeliveryCost,
                                 @Value("${costs.premiumdeliverycost}") double premiumDeliveryCost) {
        this.usersClient = usersClient;
        this.standardDeliveryCost = standardDeliveryCost;
        this.premiumDeliveryCost = premiumDeliveryCost;
    }

    public double get(String email) {
        User user = usersClient.getUser(email);
        if (user.getAccountType().equalsIgnoreCase("premium account")) {
            return premiumDeliveryCost;
        }
        return standardDeliveryCost;
    }
}
