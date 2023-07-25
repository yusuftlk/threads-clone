package com.project.threadsclone.dto;

import java.time.LocalDateTime;

public class PostDto {
    private Long id;
    private UserDto user;
    private String title;
    private Integer totalLike;
    private Integer totalComment;
    private LocalDateTime createdAt;
    private String image;
}
