package academy.everyonecodes.endpoint;

import academy.everyonecodes.domein.Product;
import academy.everyonecodes.logic.Shop;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductsEndpoint {
    private final Shop shop;

    public ProductsEndpoint(Shop shop) {
        this.shop = shop;
    }

    @PostMapping
    @Secured("ROLE_OWNER")
    Product post(@RequestBody Product product) {
        return shop.loadProduct(product);
    }

    @GetMapping
    List<Product> getAll() {
        return shop.getAll();
    }

    @GetMapping("/premium")
    @Secured("ROLE_PREMIUM")
    List<Product> getAllPremium() {
        return shop.getPremium();
    }
}
