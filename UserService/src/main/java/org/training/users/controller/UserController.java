package org.training.users.controller;



import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.users.model.dto.Response;
import org.training.users.model.dto.UserDto;
import org.training.users.model.enums.UserStatus;
import org.training.users.service.UserService;

import java.util.List;

import static org.training.users.constants.UriConstants.USERS_API;


@RestController
@RequestMapping(USERS_API)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PostMapping("/{userId}")
    public ResponseEntity<Response> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.CREATED);
    }

    @GetMapping("/productInfo/{userId}")
    public ResponseEntity<UserDto> getUserProductInfoByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserProductInfoByUserId(userId));
    }

}
