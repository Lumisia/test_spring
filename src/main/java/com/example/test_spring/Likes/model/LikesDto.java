package com.example.test_spring.Likes.model;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.User.model.User;
import lombok.Builder;
import lombok.Getter;

public class LikesDto {

    @Getter
    public static class ReqLikes {
        private Long feed_idx;
        private Long user_idx;

        public Likes toEntity() {
            return Likes.builder()
                    .feed(this.feed_idx)
                    .user(this.user_idx)
                    .build();
        }
    }
    @Builder
    @Getter
    public static class ResLikes {
        private Long feed_idx;
        private Long user_idx;

        public static ResLikes form(Likes entity) {
            return ResLikes.builder()
                    .feed_idx(entity.getFeed())
                    .user_idx(entity.getUser())
                    .build();
        }
    }
}
