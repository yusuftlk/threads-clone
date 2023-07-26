package com.project.threadsclone.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class PostDto {
    private Long id;
    private String title;
    private Integer totalLike;
    private Integer totalComment;
    private LocalDateTime createdAt;
    private String image;
    private List<CommentDto> comments;
    private List<LikesDto> likes;


}
