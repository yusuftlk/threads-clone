package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.dto.LikesDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UpdatePostRequest {
    @NotBlank(message = "title is not be empty")
    private String title;

    @NotBlank(message = "image is not be empty")
    private String image;

}
