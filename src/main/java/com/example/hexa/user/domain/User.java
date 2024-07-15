package com.example.hexa.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class User {

    private final Long id;
    private final String email;
    private final String nickname;
    private final String address;
    private final UserStatus status;

    // from하나의 매개변수 of는 여러개
    public static User from(UserCreate userCreate){
        return User.builder()
            .email(userCreate.getEmail())
            .nickname(userCreate.getNickname())
            .address(userCreate.getAddress())
            .status(UserStatus.ACTIVE)
            .build();
    }

}
