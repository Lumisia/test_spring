package com.example.test_spring.User.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Builder
public class AuthUserDetails implements UserDetails {
    private Long idx;
    private String email;
    private String username;
    private String password;

    public static AuthUserDetails form(User entity) {
        return AuthUserDetails.builder()
                .idx(entity.getIdx())
                .username(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public String getUsername() {
        return username;
    }

}
