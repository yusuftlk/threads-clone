package com.project.threadsclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long followerId;
    private Long followingId;
    private LocalDateTime createdAt;

    public Follow(Long followerId, Long followingId, LocalDateTime createdAt) {
        this.followerId = followerId;
        this.followingId = followingId;
        this.createdAt = createdAt;
    }
}
