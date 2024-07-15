package com.example.hexa.user.service.port;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserStatus;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getByEmail(String email);

    User create(User user);

    Optional<User> getById(Long id);

    Optional<User> getByEmailAndStatus(String email, UserStatus userStatus);
}
