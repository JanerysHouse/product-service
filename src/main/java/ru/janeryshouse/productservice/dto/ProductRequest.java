package ru.janeryshouse.productservice.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link ru.janeryshouse.productservice.model.Product}
 */
public record ProductRequest(String id, String name, String description, BigDecimal price) {
}