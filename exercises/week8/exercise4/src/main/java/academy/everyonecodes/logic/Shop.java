package academy.everyonecodes.logic;

import academy.everyonecodes.domein.Product;
import academy.everyonecodes.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Shop {
    private static boolean isItOpen;
    private final ProductRepository repository;

    public Shop(ProductRepository repository) {
        this.repository = repository;
        isItOpen = true;
    }

    public void open() {
        isItOpen = true;
    }

    public void close() {
        isItOpen = false;
    }

    public Product loadProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        if (isItOpen) {
            return repository.findAll();
        }
        return new ArrayList<>();
    }

    public List<Product> getPremium() {
        if (isItOpen) {
            return repository.findAllByCategory("PREMIUM");
        }
        return new ArrayList<>();
    }
}
