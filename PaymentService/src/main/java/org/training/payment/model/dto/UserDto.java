package org.training.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate createdDate;

    private LocalDate updatedDate;
}
