package com.example.hexa.user.service;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User create(UserCreate userCreate){
        return userRepository.create(User.from(userCreate));
    }

}
