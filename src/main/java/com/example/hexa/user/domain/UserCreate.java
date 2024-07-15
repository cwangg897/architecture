package com.example.hexa.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreate {

    private String email;
    private String nickname;
    private String address;
}
