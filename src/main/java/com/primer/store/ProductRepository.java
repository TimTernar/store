package com.primer.store;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    Optional<Product> findByName(String name);

    Optional<Product> findByPrice(double price);
}