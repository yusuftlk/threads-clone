package com.project.threadsclone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class LikesDto {
    private Long id;
    private PostDto post;
    private UserDto user;
    private LocalDateTime createdAt;
}
