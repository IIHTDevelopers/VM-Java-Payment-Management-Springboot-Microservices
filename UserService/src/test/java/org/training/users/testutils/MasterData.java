package org.training.users.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.training.users.model.dto.UserDto;
import org.training.users.model.entity.Users;
import org.training.users.model.enums.UserStatus;

import java.time.LocalDate;

public class MasterData {


    public static UserDto getUserDto() {
        return UserDto.builder()
                .userId(123L)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .status(UserStatus.ACTIVE)
                .createdDate(LocalDate.of(2024, 3, 6))
                .updatedDate(null)
                .build();
    }

    public static Users getUser() {
        return Users.builder()
                .id(123L)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+1234567890")
                .email("john.doe@example.com")
                .status(UserStatus.ACTIVE)
                .createdDate(LocalDate.of(2024, 3, 6))
                .updatedDate(null)
                .build();
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
