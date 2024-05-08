package com.project.threadsclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    private String title;
    private Integer totalLike;
    private Integer totalComment;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Likes> likes;

    @Lob
    @Column(name = "postImage",length = 1000)
    private byte[] postImage;

    public Post(User user, String title, LocalDateTime createdAt) {
        this.user = user;
        this.title = title;
        this.createdAt = createdAt;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.totalLike = 0;
        this.totalComment = 0;
    }
}
