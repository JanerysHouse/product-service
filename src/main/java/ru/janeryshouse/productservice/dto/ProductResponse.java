package ru.janeryshouse.productservice.dto;

import ru.janeryshouse.productservice.model.Product;

import java.math.BigDecimal;

/**
 * DTO for {@link Product}
 */
public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price) {
}