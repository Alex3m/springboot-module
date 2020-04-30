package academy.everyonecodes.endpoint;

import academy.everyonecodes.logic.Shop;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopEndpoint {
    private final Shop shop;

    public ShopEndpoint(Shop shop) {
        this.shop = shop;
    }

    @PutMapping("/open")
    @Secured("ROLE_OWNER")
    void openShop() {
        shop.open();
    }

    @PutMapping("/close")
    @Secured("ROLE_OWNER")
    void closeShop() {
        shop.close();
    }
}
