package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.dto.LikesDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile file;

}
