package com.example.hexa.user.controller.response;

import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final Long id;
    private final String email;
    private final String nickname;
    private final String address;
    private final UserStatus status;

    public static UserResponse from(User user){
        return UserResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .nickname(user.getNickname())
            .address(user.getAddress())
            .status(user.getStatus())
            .build();
    }

}
