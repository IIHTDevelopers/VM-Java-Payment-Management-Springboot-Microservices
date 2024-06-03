package org.training.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.product.exception.ResourceNotFound;
import org.training.product.external.UserService;
import org.training.product.mapper.ProductMapper;
import org.training.product.model.dto.Response;
import org.training.product.model.dto.UserDto;
import org.training.product.model.dto.ProductDto;
import org.training.product.model.entity.Product;
import org.training.product.repository.ProductRepository;
import org.training.product.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final UserService userService;


    @Override
    public Response addProduct(ProductDto productDto) {

        ResponseEntity<UserDto> userById = userService.getUserById(productDto.getOwnerId());
        if (userById.getBody() == null) {
            throw new ResourceNotFound();
        }
        productRepository.save(productMapper.toEntity(productDto));
        return new Response("200", "Product successfully added.");
    }

    @Override
    public Page<ProductDto> getAllProductList(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> {
            ProductDto dto = productMapper.toDto(product);
            UserDto userDto = userService.getUserById(product.getOwnerId()).getBody();
            dto.setUserDto(userDto);
            return dto;
        });
    }

    @Override
    public List<ProductDto> getProductByOwnerId(Long ownerId) {
        return productRepository.findAllByOwnerId(ownerId).stream().map(product -> {
            ProductDto productDto = productMapper.toDto(product);
            UserDto userDto = userService.getUserById(product.getOwnerId()).getBody();
            productDto.setUserDto(userDto);
            return productDto;
        }).toList();
    }

}
