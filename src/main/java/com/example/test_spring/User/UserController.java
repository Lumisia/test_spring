package com.example.test_spring.User;

import com.example.test_spring.User.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService us;

    @PostMapping("/signup")
    private ResponseEntity signup(@RequestBody UserDto.ReqSignup dto) {
        Optional<UserDto.ResSignup> result = us.save(dto);

        if(result.isPresent()) {
            return ResponseEntity.ok("등록 성공"+ " " + result);
        }else {
            return ResponseEntity.ok("실패");
        }

    }

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody UserDto.ReqLogin dto) {
        UserDto.ResLogin result = us.login(dto);

        if(result != null) {
            return ResponseEntity.ok("등록 성공"+ " " + result);
        }else {
            return ResponseEntity.ok("실패");
        }

    }
}
