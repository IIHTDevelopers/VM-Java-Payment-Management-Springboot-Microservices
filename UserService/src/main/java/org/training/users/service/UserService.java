package org.training.users.service;

import org.training.users.model.dto.Response;
import org.training.users.model.dto.UserDto;
import org.training.users.model.enums.UserStatus;

import java.util.List;

public interface UserService {
    Response createUser(UserDto userDto);

    List<UserDto> getAllUsers();


   UserDto getUserProductInfoByUserId(Long userId);

    Response updateUser(Long userId, UserDto userDto);

}
