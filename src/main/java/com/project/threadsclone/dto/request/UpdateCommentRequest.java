package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UpdateCommentRequest {

    @NotBlank(message = "comment is not be empty")
    private String comment;
}
