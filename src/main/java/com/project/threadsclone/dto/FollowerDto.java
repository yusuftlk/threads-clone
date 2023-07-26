package com.project.threadsclone.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class FollowerDto {
    private Long id;
    private String userName;
}
