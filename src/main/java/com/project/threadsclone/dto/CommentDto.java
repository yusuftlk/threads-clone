package com.project.threadsclone.dto;

import java.time.LocalDateTime;

public class CommentDto {
    private Long id;
    private PostDto post;
    private UserDto user;
    private String comment;
    private LocalDateTime createdAt;
}
