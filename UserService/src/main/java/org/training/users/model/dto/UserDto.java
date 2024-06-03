package org.training.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.users.model.enums.UserStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private UserStatus status;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String password;
    private List<ProductDto> productList = new ArrayList<>();
}
