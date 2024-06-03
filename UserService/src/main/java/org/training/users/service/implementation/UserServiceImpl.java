package org.training.users.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.training.users.exception.ResourceNotFound;
import org.training.users.external.ProductService;
import org.training.users.mapper.UsersMapper;
import org.training.users.model.dto.ProductDto;
import org.training.users.model.dto.Response;
import org.training.users.model.dto.UserDto;
import org.training.users.model.entity.Users;
import org.training.users.repository.UserRepository;
import org.training.users.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersMapper usersMapper;

    private final UserRepository userRepository;

    private final ProductService productService;

    private final PasswordEncoder passwordEncoder;

    @Value("${spring.application.ok}")
    private String success;

    @Override
    public Response createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users users
                = usersMapper.convertToEntity(userDto);
        userRepository.save(users);
        return Response.builder()
                .responseCode(success)
                .message("User created successfully").build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        return usersList.stream().map(usersMapper::convertToDto).toList();
    }


    @Override
    public UserDto getUserProductInfoByUserId(Long userId) {
        Users dbUsers = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User not found on server"));
        List<ProductDto> productDtoList = productService.getProductInfoByOwnerId(userId);
        UserDto userDto = usersMapper.convertToDto(dbUsers);
        userDto.setProductList(productDtoList);
        return userDto;
    }

    @Override
    public Response updateUser(Long userId, UserDto userDto) {
        return null;
    }
}
