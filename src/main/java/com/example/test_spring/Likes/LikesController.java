package com.example.test_spring.Likes;

import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.Likes.model.Likes;
import com.example.test_spring.Likes.model.LikesDto;
import com.example.test_spring.User.UserRepository;
import com.example.test_spring.User.UserService;
import com.example.test_spring.User.model.AuthUserDetails;
import com.example.test_spring.User.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikesController {
    private final UserRepository ur;
    private final LikesService ls;

    @PostMapping("/feed")
    public ResponseEntity feedLikes(
            @AuthenticationPrincipal AuthUserDetails user,
            @RequestBody LikesDto.ReqLikes dto) {

        Long user_idx = dto.getUser().getIdx();
        System.out.println(user_idx);

        User real_user = ur.findById(user_idx).orElseThrow(
                () -> new RuntimeException("사용자가 없습니다.")
        );
        if(real_user.getIdx() == user.getIdx()) {
            ls.save(dto);

            return ResponseEntity.ok("좋아요 성공");
        }else {
            return ResponseEntity.ok("좋아요 실패했습니다.");
        }
    }

    @PostMapping("/load")
    public ResponseEntity<List<FeedDto.ResList>>loadLikes(
            @AuthenticationPrincipal AuthUserDetails user) {

        User writer = ur.findByEmail(user.getEmail()).orElseThrow(
                () -> new RuntimeException("사용자를 찾을수 없습니다.")
        );

        List<FeedDto.ResList> result = ls.find(writer);

        return ResponseEntity.ok(result);
    }
}
