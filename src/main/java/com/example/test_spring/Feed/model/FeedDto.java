package com.example.test_spring.Feed.model;

import com.example.test_spring.User.model.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class FeedDto {

    @Getter
    public static class ReqFeed {
        private Long idx;
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
        private Integer likes;

        public static ResList form(Feed entity) {
            return ResList.builder()
                    .idx(entity.getIdx())
                    .user(entity.getUser().getName())
                    .contents(entity.getContents())
                    .updatedAt(entity.getUpdatedAt())
                    .likes(entity.getLikes())
                    .build();
        }
    }
}
