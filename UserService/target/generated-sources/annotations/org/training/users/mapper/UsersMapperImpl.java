package org.training.users.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.training.users.model.dto.UserDto;
import org.training.users.model.entity.Users;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T15:19:29+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users convertToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Users.UsersBuilder users = Users.builder();

        users.id( userDto.getUserId() );
        users.createdDate( userDto.getCreatedDate() );
        users.email( userDto.getEmail() );
        users.firstName( userDto.getFirstName() );
        users.lastName( userDto.getLastName() );
        users.password( userDto.getPassword() );
        users.phoneNumber( userDto.getPhoneNumber() );
        users.status( userDto.getStatus() );
        users.updatedDate( userDto.getUpdatedDate() );

        return users.build();
    }

    @Override
    public UserDto convertToDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.userId( users.getId() );
        userDto.createdDate( users.getCreatedDate() );
        userDto.email( users.getEmail() );
        userDto.firstName( users.getFirstName() );
        userDto.lastName( users.getLastName() );
        userDto.password( users.getPassword() );
        userDto.phoneNumber( users.getPhoneNumber() );
        userDto.status( users.getStatus() );
        userDto.updatedDate( users.getUpdatedDate() );

        return userDto.build();
    }
}
