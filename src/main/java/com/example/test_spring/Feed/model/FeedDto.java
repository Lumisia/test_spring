package com.example.test_spring.Feed.model;

import com.example.test_spring.User.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class FeedDto {

    @Getter
    @NoArgsConstructor
    @Setter
    public static class ReqFeed {
        private Long idx;
        @Setter
        private User user;
        private String contents;

        public Feed toEntity() {
            return Feed.builder()
                    .idx(this.idx)
                    .user(this.user)
                    .contents(this.contents)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ResList {
        private Long idx;
        private String user;
        private String contents;
        private LocalDateTime updatedAt;
        private Long likes;

        public static ResList form(Feed entity) {
            return ResList.builder()
                    .idx(entity.getIdx())
                    .user(entity.getUser().getUsername())
                    .contents(entity.getContents())
                    .updatedAt(entity.getUpdatedAt())
                    .likes(entity.getLikes())
                    .build();
        }
    }
    @Builder
    @Getter
    public static class ResFeed {
        private Long idx;
        private String username;
        private String contents;
        private LocalDateTime updatedAt;
        private Long likes;

        public static ResFeed form(Feed entity) {
            return ResFeed.builder()
                    .idx(entity.getIdx())
                    .username(entity.getUser().getUsername())
                    .contents(entity.getContents())
                    .updatedAt(entity.getUpdatedAt())
                    .likes(entity.getLikes())
                    .build();
        }
    }
}
