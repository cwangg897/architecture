package com.example.hexa.user.infrastructure;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus userStatus);
}
