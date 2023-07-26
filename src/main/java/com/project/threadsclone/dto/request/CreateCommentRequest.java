package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateCommentRequest {
    private Long userId;
    private Long postId;
    private String comment;
}
