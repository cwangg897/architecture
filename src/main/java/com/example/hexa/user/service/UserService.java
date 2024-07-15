package com.example.hexa.user.service;

import com.example.hexa.common.domain.exception.ResourceNotFoundException;
import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.domain.UserStatus;
import com.example.hexa.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
// 여기는 단지 도메인에게 위임(호출) 역할
public class UserService {

    private final UserRepository userRepository; // 여기가 구현한거 주니까

    public User create(UserCreate userCreate){
        return userRepository.create(User.from(userCreate));
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getById(id).orElseThrow(()
            -> new ResourceNotFoundException("존재하지 않는 유저입니다"));
    }

    @Transactional(readOnly = true)
    public User getByEmailAndStatus(String email, UserStatus userStatus) {
        return userRepository.getByEmailAndStatus(email, userStatus).orElseThrow(() ->
            new ResourceNotFoundException("존재하지 않는 유저입니다"));
    }
}
