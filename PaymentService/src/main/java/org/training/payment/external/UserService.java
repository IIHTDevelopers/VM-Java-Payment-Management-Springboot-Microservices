package org.training.payment.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.training.payment.model.dto.UserDto;

@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId);

}
