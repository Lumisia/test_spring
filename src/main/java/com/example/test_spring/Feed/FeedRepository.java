package com.example.test_spring.Feed;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.Feed.model.FeedDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}
