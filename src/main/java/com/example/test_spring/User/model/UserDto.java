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

        public static ResSignup form(User entity) {
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
    }

    @Getter
    @Builder
    public static class ResLogin {
        private Long idx;
        private String name;

        public static ResLogin form(User entity) {
            return ResLogin.builder()
                    .idx(entity.getIdx())
                    .name(entity.getName())
                    .build();
        }
    }
}
