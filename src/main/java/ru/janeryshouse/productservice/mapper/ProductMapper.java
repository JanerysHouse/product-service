package ru.janeryshouse.productservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.janeryshouse.productservice.dto.ProductRequest;
import ru.janeryshouse.productservice.dto.ProductResponse;
import ru.janeryshouse.productservice.model.Product;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    Product toEntity(ProductRequest productRequest);

    ProductRequest toProductRequest(Product product);

    Product toEntity(ProductResponse productResponse);

    ProductResponse toProductResponse(Product product);
}