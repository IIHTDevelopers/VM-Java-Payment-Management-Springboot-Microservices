package org.training.users.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.training.users.model.enums.UserStatus;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;
    private String password;

    @CreationTimestamp
    private LocalDate createdDate;

    @CreationTimestamp
    private LocalDate updatedDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
