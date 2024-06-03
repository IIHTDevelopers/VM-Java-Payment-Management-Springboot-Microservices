package org.training.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.users.model.entity.Users;
import org.training.users.model.enums.UserStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByStatus(UserStatus status);
    Optional<Users> findByEmail(String email);

}
