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
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String userName;
    private LocalDateTime createdAt;
    private byte[] userProfileImage;
}
