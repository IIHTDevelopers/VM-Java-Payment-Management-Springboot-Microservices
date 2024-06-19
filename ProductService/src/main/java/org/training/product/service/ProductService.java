package org.training.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.training.product.model.dto.Response;
import org.training.product.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    Response addProduct(ProductDto productDto);

    Page<ProductDto> getAllProductList(Pageable pageable);

    List<ProductDto> getProductByOwnerId(Long ownerId);

}
