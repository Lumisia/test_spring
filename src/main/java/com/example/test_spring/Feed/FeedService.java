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

        Feed write = dto.toEntity();
        fr.save(write);
    }
    public List<FeedDto.ResList> list() {

        List<Feed> feedList = fr.findAll();

        return feedList.stream().map(FeedDto.ResList::form).toList();
    }

    public FeedDto.ResFeed read(Long idx) {

        Feed feed = fr.findById(idx).orElseThrow(
                () -> new RuntimeException("글이 없습니다.")
        );

        return FeedDto.ResFeed.form(feed);
    }
}
