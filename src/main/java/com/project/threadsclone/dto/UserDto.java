package com.project.threadsclone.dto;

import com.project.threadsclone.model.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private String username;
    private LocalDateTime createdAt;
    private byte[] userProfileImage;
    private boolean isActive;
    private Set<Role> authorities;
}
