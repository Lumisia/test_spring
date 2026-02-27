package com.example.test_spring.Likes;

import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.Likes.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    List<FeedDto.ResList> findAllByUserIdx(Long idx);
}
