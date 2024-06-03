package org.training.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.product.model.dto.Response;
import org.training.product.model.dto.ProductDto;
import org.training.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Response> addProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<ProductDto>> getProductByOwnerId(@PathVariable Long ownerId) {
        return new ResponseEntity<>(productService.getProductByOwnerId(ownerId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ProductDto>> getAllProductList(Pageable pageable) {
        return new ResponseEntity<>(productService.getAllProductList(pageable), HttpStatus.OK);
    }

}
