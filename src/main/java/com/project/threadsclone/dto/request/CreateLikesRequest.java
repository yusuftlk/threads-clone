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
public class CreateLikesRequest {

    @NotNull(message = "userId is not be empty")
    private Long userId;

    @NotBlank(message = "postId is not be empty")
    private Long postId;
}
