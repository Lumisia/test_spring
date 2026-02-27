package com.example.test_spring.Likes;

import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.Likes.model.Likes;
import com.example.test_spring.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    // 1. 유저와 피드로 특정 좋아요 찾기 (직접 쿼리 작성)
    @Query("SELECT l FROM Likes l WHERE l.user = :user AND l.feed.idx = :feedIdx")
    Optional<Likes> findAllByUser(@Param("user") User user, @Param("feedIdx") Long feedIdx);

    // 2. 특정 피드의 좋아요 개수 세기
    Long countByFeedIdx(Long feedIdx);
}
