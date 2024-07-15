package com.example.hexa.user.controller;

import com.example.hexa.common.controller.response.ApiResponse;
import com.example.hexa.user.controller.response.UserResponse;
import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    // 회원가입
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> create(@RequestBody UserCreate userCreate){
        User user = userService.create(userCreate);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ApiResponse.of(HttpStatus.CREATED, UserResponse.from(user)));
    }

}
