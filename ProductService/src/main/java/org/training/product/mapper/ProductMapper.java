package org.training.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.training.product.model.dto.ProductDto;
import org.training.product.model.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "productId", target = "id")
    Product toEntity(ProductDto productDto);
    @Mapping(source = "id", target = "productId")
    ProductDto toDto(Product product);

}
