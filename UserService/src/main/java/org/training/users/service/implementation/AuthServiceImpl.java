package org.training.users.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.training.users.service.AuthService;
import org.training.users.service.JwtService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}
