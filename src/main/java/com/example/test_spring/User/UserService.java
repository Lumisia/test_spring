package com.example.test_spring.User;

import com.example.test_spring.User.model.User;
import com.example.test_spring.User.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository ur;

    public Optional<UserDto.ResSignup> save(UserDto.ReqSignup dto) {

        User result = dto.toEntity();
        ur.save(result);

        return Optional.ofNullable(UserDto.ResSignup.form(result));
    }

    public UserDto.ResLogin login(UserDto.ReqLogin dto) {
        UserDto.ResLogin result = ur.findByEmailAndPassword(
                dto.getEmail(),
                dto.getPassword());

        return result;
    }
}
