package com.project.threadsclone.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreatePostRequest {
    private Long userId;
    private String title;
    private String image;

}
