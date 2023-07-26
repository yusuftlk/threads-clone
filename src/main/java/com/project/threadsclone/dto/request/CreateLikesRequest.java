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
public class CreateLikesRequest {
    private Long userId;

    private Long postId;
}
