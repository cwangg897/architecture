package com.example.hexa.user.infrastructure;

import com.example.hexa.common.infrastructure.BaseTimeEntity;
import com.example.hexa.user.domain.User;
import com.example.hexa.user.domain.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String nickname;
    @Column
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;


    public static UserEntity from(User user){
        return UserEntity.builder()
            .email(user.getEmail())
            .nickname(user.getNickname())
            .address(user.getAddress())
            .status(user.getStatus())
            .build();
    }

    public User toModel(){
        return User.builder()
            .id(id)
            .email(email)
            .nickname(nickname)
            .address(address)
            .status(status)
            .build();
    }
}
