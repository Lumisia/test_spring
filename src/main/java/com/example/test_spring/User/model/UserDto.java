package com.example.test_spring.User.model;

import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class ReqSignup {
        private String email;
        private String name;
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .name(this.name)
                    .password(this.password)
                    .build();
        }
    }
    @Getter
    @Builder
    public static class ResSignup {
        private String email;
        private String name;

        public ResSignup form(User entity) {
            return ResSignup.builder()
                    .email(entity.getEmail())
                    .name(entity.getName())
                    .build();
        }
    }

    @Getter
    public static class ReqLogin {
        private String email;
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .password(this.password)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class ResLogin {
        private String name;

        public ResLogin form(User entity) {
            return ResLogin.builder()
                    .name(entity.getName())
                    .build();
        }
    }
}
