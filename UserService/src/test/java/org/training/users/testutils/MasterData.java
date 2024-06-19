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
        UserDto userDto = new UserDto();
        userDto.setUserId(123L);
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setPhoneNumber("+1234567890");
        userDto.setEmail("john.doe@example.com");
        userDto.setCreatedDate(LocalDate.of(2024, 3, 6));
        userDto.setUpdatedDate(null);
        return userDto;

    }

    public static Users getUser() {
        Users userDto = new Users();
     userDto.setId(123L);
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setPhoneNumber("+1234567890");
        userDto.setEmail("john.doe@example.com");
        userDto.setCreatedDate(LocalDate.of(2024, 3, 6));
        userDto.setUpdatedDate(null);
        return userDto;
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
