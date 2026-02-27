package com.example.test_spring.Feed;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.User.UserRepository;
import com.example.test_spring.User.model.AuthUserDetails;
import com.example.test_spring.User.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feed")
@RequiredArgsConstructor
@RestController
public class FeedController {
    private final UserRepository ur;
    private final FeedService fs;

    @PostMapping("/write")
    public ResponseEntity write(
            @AuthenticationPrincipal AuthUserDetails user,
            @ModelAttribute FeedDto.ReqFeed dto) {

        String email = user.getEmail();
        System.out.println(email);
        System.out.println(dto.getContents());

        User writer = ur.findByEmail(email).orElseThrow(
                () -> new RuntimeException("사용자를 찾을수 없습니다.")
        );
        dto.setUser(writer);
        fs.write(dto);

        return ResponseEntity.ok("성공");
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeedDto.ResList>> list() {

        List<FeedDto.ResList> list = fs.list();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/details/{idx}")
    public ResponseEntity<FeedDto.ResFeed> read(
            @PathVariable("idx") Long idx) {

        try {
            // 서비스 계층에서 idx로 게시글 조회
            FeedDto.ResFeed formDto = fs.read(idx);

            return ResponseEntity.ok(formDto);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(null);
        }
    }
}
