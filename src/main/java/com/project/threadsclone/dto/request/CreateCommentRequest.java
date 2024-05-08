package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateCommentRequest {

    @NotNull(message = "userId is not be empty")
    private Long userId;

    @NotNull(message = "postId is not be empty")
    private Long postId;

    @NotBlank(message = "comment is not be empty")
    private String comment;
}
