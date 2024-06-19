package org.training.users.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.training.users.configuration.FeignClientConfiguration;
import org.training.users.model.dto.ProductDto;

import java.util.List;

@FeignClient(name = "product-service", url = "product", configuration = FeignClientConfiguration.class)
public interface ProductService {
    @GetMapping("/api/products/owner/{ownerId}")
    List<ProductDto> getProductInfoByOwnerId(Long userId);

}
