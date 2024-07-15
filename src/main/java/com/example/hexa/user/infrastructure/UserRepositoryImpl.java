package com.example.hexa.user.infrastructure;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.domain.UserStatus;
import com.example.hexa.user.service.port.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

// 대신 여기서는 Entity로 된거를 단지 도메인으로 변환시켜서 주는 과정만 거치는거임 따지고보면
// RDB에 의존적이지 않게 이렇게 코드짬
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User create(User user) {
        return jpaRepository.save(UserEntity.from(user)).toModel();
    }

    @Override
    public Optional<User> getById(Long id) {
        return jpaRepository.findById(id).map(UserEntity::toModel);
    }

    @Override
    public Optional<User> getByEmailAndStatus(String email, UserStatus userStatus) {
        return jpaRepository.findByEmailAndStatus(email, userStatus).map(UserEntity::toModel);
    }
}
