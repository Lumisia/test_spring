package com.example.test_spring.User.model;

import lombok.Builder;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class ReqSignup {
        private String email;
        private String username;
        private String password;

        public User toEntity() {
            return User.builder()
                    .email(this.email)
                    .username(this.username)
                    .password(this.password)
                    .build();
        }
    }
    @Getter
    @Builder
    public static class ResSignup {
        private String email;
        private String username;

        public static ResSignup form(User entity) {
            return ResSignup.builder()
                    .email(entity.getEmail())
                    .username(entity.getUsername())
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
        private String username;

        public static ResLogin form(User entity) {
            return ResLogin.builder()
                    .idx(entity.getIdx())
                    .username(entity.getUsername())
                    .build();
        }
    }
}
