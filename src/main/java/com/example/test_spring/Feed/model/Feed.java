package com.example.test_spring.Feed.model;

import com.example.test_spring.Likes.model.Likes;
import com.example.test_spring.User.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "likes")
    private Likes likes;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
        this.likes = Likes.builder()
                .likes(0)
                .build();
    }

    public void setLikes() {
        likes = Likes.builder()
                .likes(this.likes.getLikes() + 1)
                .build();
    }

    public void update(FeedDto.ReqFeed dto) {
        this.contents = dto.getContents();
        this.updatedAt = LocalDateTime.now();
    }
}
