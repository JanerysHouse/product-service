package ru.janeryshouse.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.janeryshouse.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}