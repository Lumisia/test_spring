package com.example.test_spring.Feed;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.Feed.model.FeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedRepository fr;

    public void write(FeedDto.ReqFeed dto) {

    }
    public List<FeedDto.ResList> list() {

    }

    public FeedDto.ResFeed read(Long idx) {

        Feed feed = fr.

    }
}
