package com.project.threadsclone.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreatePostRequest {
    @NotBlank(message = "userId is not be empty")
    private Long userId;

    @NotBlank(message = "title is not be empty")
    private String title;

    private String image;

}
