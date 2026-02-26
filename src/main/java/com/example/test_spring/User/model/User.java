package com.example.test_spring.User.model;

import com.example.test_spring.Feed.model.Feed;
import com.example.test_spring.Likes.model.Likes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(nullable = false)
    private String email;
    private String name;
    @Setter
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Feed> feedList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Likes> likesList;
}
