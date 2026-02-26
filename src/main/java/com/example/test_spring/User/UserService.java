package com.example.test_spring.User;

import com.example.test_spring.User.model.AuthUserDetails;
import com.example.test_spring.User.model.User;
import com.example.test_spring.User.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final PasswordEncoder pe;
    private final UserRepository ur;

    public Optional<UserDto.ResSignup> save(UserDto.ReqSignup dto) {

        User result = dto.toEntity();
        result.setPassword(pe.encode(dto.getPassword()));
        ur.save(result);

        return Optional.ofNullable(UserDto.ResSignup.form(result));
    }

    public UserDto.ResLogin login(UserDto.ReqLogin dto) {
        UserDto.ResLogin result = ur.findByEmailAndPassword(
                dto.getEmail(),
                dto.getPassword());

        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserService 실행됨");

        // TODO : 6번
        User user = ur.findByEmail(username).orElseThrow();

        // TODO : 7번
        return AuthUserDetails.form(user);
    }
}
