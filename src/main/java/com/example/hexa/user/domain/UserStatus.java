package com.example.hexa.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    INACTIVE("비활성"),
    ACTIVE("활성유저");
    private final String text;
}
