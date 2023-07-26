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
public class CommentDto {
    private Long id;
    private UserDto user;
    private String comment;
    private LocalDateTime createdAt;
}
