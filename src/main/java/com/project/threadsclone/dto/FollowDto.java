package com.project.threadsclone.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class FollowDto {
    private Long id;
    private Long followerId;
    private Long followingId;
    private LocalDateTime createdAt;
}
