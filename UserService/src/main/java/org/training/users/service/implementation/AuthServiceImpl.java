package org.training.users.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.users.service.AuthService;
import org.training.users.service.JwtService;


@Service

public class AuthServiceImpl implements AuthService {
    @Autowired
    private  JwtService jwtService;

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
