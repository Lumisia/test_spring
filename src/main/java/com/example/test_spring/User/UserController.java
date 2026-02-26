package com.example.test_spring.User;

import com.example.test_spring.User.model.AuthUserDetails;
import com.example.test_spring.User.model.User;
import com.example.test_spring.User.model.UserDto;
import com.example.test_spring.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
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
    public ResponseEntity login(@RequestBody UserDto.ReqLogin dto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword(), null);

        Authentication authentication = authenticationManager.authenticate(token);
        AuthUserDetails user = (AuthUserDetails) authentication.getPrincipal();

        System.out.println(dto.getEmail() + " " + dto.getPassword());
        if(user != null) {
            String jwt = jwtUtil.createToken(user.getIdx(), user.getEmail());
            UserDto.ResLogin result = UserDto.ResLogin.form(
                    User.builder()
                            .idx(user.getIdx())
                            .name(user.getUsername())
                            .build()
            );

            return ResponseEntity.ok().header("Set-Cookie", "ATOKEN=" + jwt + "; Path=/").body(result);
        }

        return ResponseEntity.ok("로그인 실패");

    }
}
