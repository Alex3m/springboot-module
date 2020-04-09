package academy.everyonecodes.basket.logic;

import academy.everyonecodes.basket.data.ItemSelection;
import academy.everyonecodes.basket.data.Summary;
import org.springframework.stereotype.Service;

@Service
public class SummaryCalculator {
    private final Basket basket;
    private final DeliveryPriceProvider deliveryPriceProvider;

    public SummaryCalculator(Basket basket, DeliveryPriceProvider deliveryPriceProvider) {
        this.basket = basket;
        this.deliveryPriceProvider = deliveryPriceProvider;
    }

    public Summary calculate(ItemSelection itemSelection) {
        String userEmail = itemSelection.getUserEmail();
        String itemName = itemSelection.getItemName();
        double itemPrice = itemSelection.getItemPrice();
        double deliveryCost = deliveryPriceProvider.get(userEmail);
        double totalPrice = itemPrice + deliveryCost;
        Summary currentSummery = new Summary(userEmail, itemName, itemPrice, deliveryCost, totalPrice);
        basket.addSummary(currentSummery);
        return currentSummery;
    }

}
