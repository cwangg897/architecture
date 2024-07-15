package com.example.hexa.user.infrastructure;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.service.port.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User create(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toModel();
    }
}
