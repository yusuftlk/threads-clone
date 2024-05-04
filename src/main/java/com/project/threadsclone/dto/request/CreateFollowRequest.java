package com.project.threadsclone.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateFollowRequest {

    @NotBlank(message = "userId is not be empty")
    private Long userId;

    @NotBlank(message = "followingId is not be empty")
    private Long followingId;
}
