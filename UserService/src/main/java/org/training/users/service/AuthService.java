package org.training.users.service;

public interface AuthService {
     String generateToken(String username);
     void validateToken(String token);
}
