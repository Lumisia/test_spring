package com.example.test_spring.Likes.model;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.User.model.User;
import lombok.Builder;
import lombok.Getter;

public class LikesDto {

    @Getter
    public static class ReqLikes {
        private Feed feed;
        private User user;

        public Likes toEntity() {
            return Likes.builder()
                    .feed(this.feed)
                    .user(this.user)
                    .build();
        }
    }
    @Builder
    @Getter
    public static class ResLikes {
        private Feed feed;
        private User user;

        public static ResLikes form(Likes entity) {
            return ResLikes.builder()
                    .feed(entity.getFeed())
                    .user(entity.getUser())
                    .build();
        }
    }
}
