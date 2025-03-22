package ru.janeryshouse.productservice.mapper;

import org.mapstruct.Mapper;
import ru.janeryshouse.productservice.dto.ProductRequest;
import ru.janeryshouse.productservice.dto.ProductResponse;
import ru.janeryshouse.productservice.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);
}