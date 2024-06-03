package org.training.product.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {

    private Long productId;

    private String name;
    private double price;

    private String description;

    @NotNull(message = "Owner id can not be null")
    private Long ownerId;

    private UserDto userDto;
}
