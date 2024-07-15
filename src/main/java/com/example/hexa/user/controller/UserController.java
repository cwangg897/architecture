package com.example.hexa.user.controller;

import com.example.hexa.common.controller.response.ApiResponse;
import com.example.hexa.user.controller.response.UserResponse;
import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserCreate;
import com.example.hexa.user.domain.UserStatus;
import com.example.hexa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 도메인에 대한 변환과정은 컨트롤러 단에서 valid랑 인증인가랑
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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(UserResponse.from(user)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<UserResponse>> getByEmailAndStatus(@RequestParam("email") String email,
        @RequestParam("status") UserStatus userStatus){
        User user = userService.getByEmailAndStatus(email, userStatus);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(UserResponse.from(user)));
    }




}
