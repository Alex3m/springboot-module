package academy.everyonecodes.repository;

import academy.everyonecodes.domein.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByCategory(String category);
}
