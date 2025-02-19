package ru.janeryshouse.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.janeryshouse.productservice.dto.ProductRequest;
import ru.janeryshouse.productservice.dto.ProductResponse;
import ru.janeryshouse.productservice.model.Product;
import ru.janeryshouse.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<Product> getOne(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));

    }
    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        return productService.create(request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.update(request));
    }
}

