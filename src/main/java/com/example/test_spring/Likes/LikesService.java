package com.example.test_spring.Likes;

import com.example.test_spring.Feed.model.FeedDto;
import com.example.test_spring.Likes.model.Likes;
import com.example.test_spring.Likes.model.LikesDto;
import com.example.test_spring.User.model.AuthUserDetails;
import com.example.test_spring.User.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository lr;

    public void save(LikesDto.ReqLikes dto) {

        lr.save(dto.toEntity());
    }

    public List<FeedDto.ResList> find(User user) {

        return lr.findAllByUser(user);
    }
}
