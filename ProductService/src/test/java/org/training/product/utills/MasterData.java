package org.training.product.utills;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.training.product.model.dto.ProductDto;
import org.training.product.model.dto.UserDto;

import java.time.LocalDate;

public class MasterData {


    public static UserDto getUserDto() {
        return UserDto.builder()
                .userId(123L)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .createdDate(LocalDate.of(2024, 3, 6))
                .updatedDate(null)
                .build();
    }

    public static ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setName("product Name");
        productDto.setProductId(1L);
        productDto.setOwnerId(123L);
        productDto.setDescription("Product Description");
        productDto.setPrice(1000L);
        productDto.setUserDto(getUserDto());
        return productDto;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
