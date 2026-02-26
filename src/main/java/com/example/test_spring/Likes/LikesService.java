package com.example.test_spring.Likes;

import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.Likes.model.Likes;
import com.example.test_spring.Likes.model.LikesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository lr;

    public void save(LikesDto.ReqLikes dto) {

        lr.save(dto.toEntity());
    }

    public List<FeedDto.ResList> find(Long user_idx) {

        List<FeedDto.ResList> result = lr.findAllByUserIdx(user_idx);

        return result;
    }
}
