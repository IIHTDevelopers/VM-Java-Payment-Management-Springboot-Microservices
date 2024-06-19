package org.training.users.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.training.users.model.dto.UserDto;
import org.training.users.model.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(source = "userId", target = "id")
    Users convertToEntity(UserDto userDto);

    @Mapping(source = "id", target = "userId")
    UserDto convertToDto(Users users);
}
