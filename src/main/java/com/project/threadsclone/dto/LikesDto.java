package com.project.threadsclone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class LikesDto {
    private Long id;
    private UserDto user;
    private LocalDateTime createdAt;
}
