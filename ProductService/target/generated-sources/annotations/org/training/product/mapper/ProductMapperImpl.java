package org.training.product.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.training.product.model.dto.ProductDto;
import org.training.product.model.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T15:19:25+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getProductId() );
        product.setDescription( productDto.getDescription() );
        product.setName( productDto.getName() );
        product.setOwnerId( productDto.getOwnerId() );
        product.setPrice( productDto.getPrice() );

        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getId() );
        productDto.setDescription( product.getDescription() );
        productDto.setName( product.getName() );
        productDto.setOwnerId( product.getOwnerId() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }
}
