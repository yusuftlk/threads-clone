package com.project.threadsclone.dto.request;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.dto.LikesDto;
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
    private String title;
    private String image;

}
