package com.project.threadsclone.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreatePostRequest {

    @NotNull(message = "userId is not be empty")
    private Long userId;

    @NotBlank(message = "title is not be empty")
    private String title;

    private MultipartFile file;

}
