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
public class UpdateCommentRequest {
    private String comment;
}
