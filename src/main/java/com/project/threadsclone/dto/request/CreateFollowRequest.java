package com.project.threadsclone.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateFollowRequest {

    @NotNull
    private Long followerId;

    @NotNull
    private Long followingId;
}
