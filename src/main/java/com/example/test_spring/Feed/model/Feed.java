package com.example.test_spring.Feed.model;

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
    private int likes;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
        likes = 0;
    }
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void setLikes() {
        this.likes++;
    }
}
