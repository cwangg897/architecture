package com.example.hexa.user.service.port;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getByEmail(String email);

    User create(User user);
}
