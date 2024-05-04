package com.project.threadsclone.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateFollowRequest {

    private Long userId;
    private Long followingId;
}
