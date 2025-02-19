package ru.janeryshouse.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.janeryshouse.productservice.dto.ProductRequest;
import ru.janeryshouse.productservice.dto.ProductResponse;
import ru.janeryshouse.productservice.mapper.ProductMapper;
import ru.janeryshouse.productservice.model.Product;
import ru.janeryshouse.productservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Entity with id `%s` not found".formatted(id)));
    }

    public Optional<ProductResponse> create(ProductRequest product) {
        return Optional.of(product)
                .map(productMapper::toEntity)
                .map(productRepository::save)
                .map(productMapper::toProductResponse)
                .map(savedProduct -> {
                    log.info("Продукт создан: {}", savedProduct);
                    return savedProduct;
                });

    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse update(ProductRequest product) {
        var entity = productRepository.findById(product.id())
                .orElseThrow(() -> new RuntimeException("Продукт не найден"));
        entity.setName(product.name());
        entity.setDescription(product.description());
        entity.setPrice(product.price());

        return productMapper.toProductResponse(productRepository.save(entity));
    }

//    public ProductResponse update(String id, ProductRequest product) {
//        log.info("Searching for product with id: {}", id);
//
//        var productEntity = productRepository.findById(id)
//                .orElseThrow(() -> {
//                    log.warn("Entity with id `{}` not found", id);
//                    return new RuntimeException("Entity with id `%s` not found".formatted(id));
//                });
//
//        log.info("Updating product with id: {}", id);
//        var updatedProduct = productMapper.toEntity(productEntity);
//        productRepository.save(updatedProduct);
//        log.info("Product with id: {} successfully updated", id);
//
//        return productMapper.toProductResponse(updatedProduct);
    }
//public Optional<ProductResponse> update(String id, ProductRequest product) {
//    log.info("Searching for product with id: {}", id);
//
//    return Optional.ofNullable(id)
//            .flatMap(productId -> {
//                var productOpt = productRepository.findById(productId);
//                if (productOpt.isEmpty()) {
//                    log.warn("Entity with id `{}` not found", id);
//                }
//                return productOpt;
//            })
//            .map(existingProduct -> {
//                log.info("Updating product with id: {}", id);
//                var updatedProduct = productMapper.toEntity(product);
//                productRepository.save(updatedProduct);
//                log.info("Product with id: {} successfully updated", id);
//                return productMapper.toProductResponse(updatedProduct);
//            });
//}

